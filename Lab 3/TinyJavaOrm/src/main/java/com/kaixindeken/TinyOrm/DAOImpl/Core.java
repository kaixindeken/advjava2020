package com.kaixindeken.TinyOrm.DAOImpl;

import com.kaixindeken.Annotation.*;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Core<T> {

    //获得表名
    public String getTableName(Class<?> clazz) throws Exception{
        if(clazz.isAnnotationPresent(Table.class)){
            Table table = clazz.getAnnotation(Table.class);
            return table.value();
        }else{
            throw new Exception(clazz.getName()+" is not Table Annotation.");
        }
    }

    //设置sql参数占位符的值
    public void setParam(List<Object> values, PreparedStatement ps, boolean isSearch) throws SQLException {
        for(int i=1;i<=values.size();i++){
            Object field_value = values.get(i-1);
            Class<?> clazz_value = field_value.getClass();
            if (clazz_value == String.class){
                if (isSearch){
                    ps.setString(i,"%"+field_value+"%");
                }else{
                    ps.setString(i,(String)field_value);
                }
            }else if (clazz_value == boolean.class || clazz_value == Boolean.class){
                ps.setBoolean(i,(Boolean) field_value);
            }else if (clazz_value == byte.class || clazz_value == Byte.class){
                ps.setByte(i,(Byte)field_value);
            }else if (clazz_value == Date.class){
                ps.setTimestamp(i,new Timestamp(((Date)field_value).getTime()));
            }else if (clazz_value.isArray()){
                Object[] array_value = (Object[]) field_value;
                StringBuffer sb = new StringBuffer();
                for (int j=0;j<array_value.length;j++){
                    sb.append(array_value[j]).append(",");
                }
                ps.setString(i,sb.deleteCharAt(sb.length()-1).toString());
            } else {
                ps.setObject(i,field_value, Types.NUMERIC);
            }
        }
    }

    //根据结果集初始化对象
    public void initObject(T t, Field[] fields, ResultSet rs)
            throws SQLException, IntrospectionException, IllegalAccessException, InvocationTargetException {
        for (Field field: fields) {
            String property_name = field.getName();
            Object param_value = null;
            Class<?> clazz_field = field.getType();
            if (clazz_field == String.class){
                param_value = rs.getString(property_name);
            }else if (clazz_field == short.class || clazz_field == Short.class){
                param_value = rs.getShort(property_name);
            }else if (clazz_field == int.class || clazz_field == Integer.class){
                param_value = rs.getInt(property_name);
            }else if(clazz_field == long.class || clazz_field == Long.class){
                param_value = rs.getLong(property_name);
            }else if (clazz_field == float.class || clazz_field == Float.class){
                param_value = rs.getFloat(property_name);
            }else if(clazz_field == double.class || clazz_field == Double.class){
                param_value = rs.getDouble(property_name);
            }else if (clazz_field == byte.class || clazz_field == Byte.class){
                param_value = rs.getByte(property_name);
            }else if (clazz_field == char.class || clazz_field == Character.class){
                param_value = rs.getCharacterStream(property_name);
            }else if (clazz_field == Date.class){
                param_value = rs.getDate(property_name);
            }else if (clazz_field.isArray()){
                //逗号分隔字符串
                param_value = rs.getString(property_name).split(",");
            }
            PropertyDescriptor pd = new PropertyDescriptor(property_name,t.getClass());
            pd.getWriteMethod().invoke(t,param_value);
        }
    }

    //根据条件返回sql条件和条件中占位符的值
    public List<Object> getSQLConditionWithVal(Map<String, Object> sqlMap){
        if (sqlMap.size() < 1){
            return null;
        }
        List<Object> list = new ArrayList<Object>();
        List<Object> field_values = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer(" where ");
        Set<Map.Entry<String,Object>> entry_sets = sqlMap.entrySet();
        Iterator<Map.Entry<String,Object>> iterator = entry_sets.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Object> entry_set = iterator.next();
            field_values.add(entry_set.getValue());
            Object value = entry_set.getValue();
            if (value.getClass() == String.class){
                sql.append(entry_set.getKey()).append(" like ").append("?").append(" and ");
            }else{
                sql.append(entry_set.getKey()).append("=").append("?").append(" and ");
            }
        }

        //删除多余and
        sql.delete(sql.lastIndexOf("and"),sql.length());

        list.add(sql.toString());
        list.add(field_values);
        return list;
    }

}
