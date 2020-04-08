package com.kaixindeken.TinyOrm.DAO;

public interface Delete<T> {
    public void delete(Object id, Class<T> tClass) throws Exception;
}
