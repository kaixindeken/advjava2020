package com.kaixindeken.simpleorm;

import com.kaixindeken.Annotation.*;
import java.sql.Timestamp;

//试卷
@Table("papers")
public class Paper{

    //试卷编号
    @Id("id")
    private int id;

    //试卷名
    @Column("name")
    private String name;

    //学院号
    @Column("college_code")
    private int college_code;

    //考试次数
    @Column("test_time")
    private int test_time;

    //时长
    @Column("duration")
    private int duration;

    //开始时间
    @Column(value = "started_at")
    private Timestamp started_at;

    //结束时间
    @Column(value = "ended_at")
    private Timestamp ended_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCollege_code() {
        return college_code;
    }

    public void setCollege_code(int college_code) {
        this.college_code = college_code;
    }

    public int getTest_time() {
        return test_time;
    }

    public void setTest_time(int test_time) {
        this.test_time = test_time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Timestamp getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Timestamp started_at) {
        this.started_at = started_at;
    }

    public Timestamp getEnded_at() {
        return ended_at;
    }

    public void setEnded_at(Timestamp ended_at) {
        this.ended_at = ended_at;
    }

    @Override
    public String toString(){
        return "考试： "+name
                +" 时长： "+duration
                +" 开始时间："+started_at
                +" 结束时间："+ended_at;
    }
}



