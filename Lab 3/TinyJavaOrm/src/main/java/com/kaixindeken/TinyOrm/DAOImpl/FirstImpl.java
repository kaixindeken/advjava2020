package com.kaixindeken.TinyOrm.DAOImpl;

import com.kaixindeken.TinyOrm.DAO.First;
import com.kaixindeken.Annotation.*;
import java.lang.reflect.Field;
import java.util.*;

public class FirstImpl<T> implements First<T> {
    private static final String TABLE_ALIAS = "t";

    @Override
    public T first(Object id, Class<T> tClass) throws Exception {
        String id_field_name="";
        Field[] fields = tClass.getDeclaredFields();
        boolean flag = false;
        for (Field field:fields){
            if (field.isAnnotationPresent(Id.class)){
                id_field_name = field.getAnnotation(Id.class).value();
                flag = true;
                break;
            }
        }

        if (!flag){
            throw new Exception(tClass.getName()+"object not found id property.");
        }

        //拼接sql
        Map<String,Object> sqlMap = new HashMap<String,Object>();
        sqlMap.put(TABLE_ALIAS+"."+id_field_name,id);

        List<T> list = new GetImpl<T>().get(sqlMap,tClass);
        return list.size() > 0 ? list.get(0):null;
    }
}
