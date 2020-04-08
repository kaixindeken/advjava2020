package com.kaixindeken.TinyOrm.DAOImpl;

import com.kaixindeken.TinyOrm.DAO.Update;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.*;
import com.kaixindeken.Annotation.*;
import com.kaixindeken.TinyOrm.*;

public class UpdateImpl<T> implements Update<T> {

    @Override
    public void update(T t) throws Exception {
        Class<?> clazz = t.getClass();
        //获取表名
        String table_name = new Core<T>().getTableName(clazz);

        List<String> field_names = new ArrayList<String>();
        List<Object> field_values = new ArrayList<Object>();
        List<String> place_holders = new ArrayList<String>();

        String id_field_name="";
        Object id_field_value="";
        //获取字段名和值
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),t.getClass());
            if (field.isAnnotationPresent(Id.class)){
                id_field_name = field.getAnnotation(Id.class).value();
                id_field_value = pd.getReadMethod().invoke(t);
            }else if (field.isAnnotationPresent(Column.class)){
                field_names.add(field.getAnnotation(Column.class).value());
                field_values.add(pd.getReadMethod().invoke(t));
                place_holders.add("?");
            }
        }
        field_names.add(id_field_name);
        field_values.add(id_field_value);
        place_holders.add("?");

        StringBuilder sql = new StringBuilder("");
        sql.append("update ").append(table_name).append(" set ");
        int index = field_names.size()-1;
        for (int i=0; i<index; i++){
            sql.append(field_names.get(i)).append("=").append(place_holders.get(i)).append(",");
        }
        sql.deleteCharAt(sql.length()-1).append(" where ").append(id_field_name).append("=").append("?");
        PreparedStatement ps = JdbcDAOHelper.getCon().prepareStatement(sql.toString());
        //设置SQL参数占位符的值
        new Core<T>().setParam(field_values,ps,false);
        //执行sql
        ps.execute();
        JdbcDAOHelper.release(ps,null);
        System.out.println(sql+"\n"+clazz.getSimpleName()+"更新成功");
    }
}
