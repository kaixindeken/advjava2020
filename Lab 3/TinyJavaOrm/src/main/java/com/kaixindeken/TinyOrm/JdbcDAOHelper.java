package com.kaixindeken.TinyOrm;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JdbcDAOHelper {

    private static Connection con;
    private static Properties properties;

    static {
        properties = new Properties();
        InputStream in = JdbcDAOHelper.class.getResourceAsStream("mysql.properties");

        try{
            properties.load(in);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    //加载驱动建立连接
    public static Connection getCon(){
        try{
            if (con == null){
                Class.forName(properties.getProperty("DBDriver"));
                try{
                    con = DriverManager.getConnection(
                            properties.getProperty("URL"),
                            properties.getProperty("USERNAME"),
                            properties.getProperty("PASSWORD")
                    );
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();;
        }
        return con;
    }

    //释放资源
    public static void release(PreparedStatement ps, ResultSet rs){
        //关闭连接
        if (con != null){
            try{
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
            con = null;
        }
        //清除PreparedStatement接口占用的资源
        if (ps != null){
            try{
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        //清楚ResultSet中的资源
        if (rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
