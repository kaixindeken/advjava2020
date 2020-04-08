package com.kaixindeken.TinyOrm.DAOImpl;

import com.kaixindeken.TinyOrm.DAO.Delete;
import com.kaixindeken.TinyOrm.JdbcDAOHelper;

import java.sql.PreparedStatement;

public class DeleteImpl<T> implements Delete<T> {
    @Override
    public void delete(Object id, Class<T> tClass) throws Exception {
        //获取表名
        String table_name = new Core<T>().getTableName(tClass);

        StringBuilder sql = new StringBuilder("");
        sql.append("delete from ").append(table_name).append(" where id = ").append(id);
        PreparedStatement ps = JdbcDAOHelper.getCon().prepareStatement(sql.toString());
        ps.execute();
        JdbcDAOHelper.release(ps,null);
        System.out.println(sql+"\n"+tClass.getSimpleName()+"删除成功");
    }
}
