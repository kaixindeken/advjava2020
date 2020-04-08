package com.kaixindeken.TinyOrm.DAO;

import java.util.List;
import java.util.Map;

public interface Get<T> {
    //根据条件批量查找
    public List<T> get(Map<String,Object> sqlWhereMap, Class<T> tClass) throws Exception;
}
