package com.kaixindeken.TinyOrm.DAOImpl;

import com.kaixindeken.TinyOrm.DAO.Get;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import com.kaixindeken.Annotation.*;
import com.kaixindeken.TinyOrm.JdbcDAOHelper;

public class GetImpl<T> implements Get<T> {

    private static final String TABLE_ALIAS = "t";
    @Override
    public List<T> get(Map<String, Object> sql_where_map, Class<T> tClass) throws Exception {
        List<T> list = new ArrayList<T>();
        String table_name = new Core<T>().getTableName(tClass);
        String id_field_name = "";

        StringBuffer field_names = new StringBuffer();
        Field[] fields = tClass.getDeclaredFields();
        for (Field field:fields){
            String property_name = field.getName();
            if (field.isAnnotationPresent(Id.class)){
                id_field_name = field.getAnnotation(Id.class).value();
                field_names.append(TABLE_ALIAS+"."+id_field_name)
                        .append(" as ")
                        .append(property_name)
                        .append(",");
            }else if (field.isAnnotationPresent(Column.class)){
                field_names.append(TABLE_ALIAS+"."+field.getAnnotation(Column.class).value())
                        .append(" as ")
                        .append(property_name)
                        .append(",");
            }
        }
        //删除逗号
        field_names.deleteCharAt(field_names.length()-1);

        //拼装sql
        String sql = "select "+field_names+" from "+table_name+" "+TABLE_ALIAS;
        PreparedStatement ps = null;
        List<Object> values = null;
        if (sql_where_map != null){
            List<Object> sql_condition_values = new Core<T>().getSQLConditionWithVal(sql_where_map);
            if (sql_condition_values != null){
                //拼接sql条件
                String sql_where = (String) sql_condition_values.get(0);
                sql += sql_where;
                //得到sql条件占位符的值
                values = (List<Object>) sql_condition_values.get(1);
            }
        }

        //设置参数占位符的值
        if (values != null){
            ps = JdbcDAOHelper.getCon().prepareStatement(sql);
            new Core<T>().setParam(values,ps,true);
        }else{
            ps=JdbcDAOHelper.getCon().prepareStatement(sql);
        }

        //执行sql
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            T t = tClass.newInstance();
            new Core<T>().initObject(t,fields,rs);
            list.add(t);
        }

        //释放资源
        JdbcDAOHelper.release(ps,rs);

        System.out.println(sql);
        return list;
    }
}
