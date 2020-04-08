package com.kaixindeken.TinyOrm.DAO;

public interface First<T> {
    //查找单个数据
    public T first(Object id, Class<T> tClass) throws Exception;
}
