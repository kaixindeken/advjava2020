package com.kaixindeken.TinyOrm.DAOImpl;

import com.kaixindeken.Annotation.*;
import com.kaixindeken.TinyOrm.DAO.*;
import com.kaixindeken.TinyOrm.JdbcDAOHelper;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class InsertImpl<T> implements Insert<T> {
    private static final String Table_Alias="t";
    @Override
    public void insert(T t) throws Exception {
        Class<?> clazz = t.getClass();

        //获取表名
        String table_name = new Core<T>().getTableName(clazz);
        //字段名
        StringBuilder field_names = new StringBuilder();
        //字段值
        List<Object> field_values = new ArrayList<Object>();
        //占位符
        StringBuilder place_holders = new StringBuilder();

        //获取字段名和值
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(),t.getClass());
            if (field.isAnnotationPresent(Id.class)){
                field_names.append(field.getAnnotation(Id.class).value()).append(",");
                field_values.add(pd.getReadMethod().invoke(t));
            }else if (field.isAnnotationPresent(Column.class)){
                field_names.append(field.getAnnotation(Column.class).value()).append(",");
                field_values.add(pd.getReadMethod().invoke(t));
            }
            place_holders.append("?").append(",");
        }

        //删除最后一个逗号
        field_names.deleteCharAt(field_names.length()-1);
        place_holders.deleteCharAt(place_holders.length()-1);

        //拼接sql
        StringBuilder sql = new StringBuilder("");
        sql.append("insert into ").append(table_name)
                .append(" (")
                .append(field_names.toString())
                .append(")")
                .append(" values ")
                .append("(")
                .append(place_holders)
                .append(")");
        PreparedStatement ps = JdbcDAOHelper.getCon().prepareStatement(sql.toString());

        //设置sql参数占位符的值
        new Core<T>().setParam(field_values,ps,false);

        //执行sql
        ps.execute();
        JdbcDAOHelper.release(ps,null);

        System.out.println(sql+"\n"+clazz.getSimpleName()+"插入成功");
    }
}
