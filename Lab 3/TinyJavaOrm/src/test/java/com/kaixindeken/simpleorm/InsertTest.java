package com.kaixindeken.simpleorm;

import com.kaixindeken.TinyOrm.DAO.Insert;
import com.kaixindeken.TinyOrm.DAOImpl.InsertImpl;
import org.junit.Test;

import java.sql.Timestamp;

public class InsertTest {

    private Insert<Paper> paperInsert = new InsertImpl<Paper>();
    @SuppressWarnings("deprecation")
    @Test
    public void TestInsert() throws Exception{
        //构造一张试卷插入库
        Paper paper = new Paper();
        paper.setCollege_code(216);
        paper.setName("unknown test");
        paper.setDuration(60);
        paper.setTest_time(10);
        paper.setStarted_at(new Timestamp(System.currentTimeMillis()));
        paper.setEnded_at(new Timestamp(System.currentTimeMillis()));
        paperInsert.insert(paper);
    }

}
