package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC
 */
public class jdbcDemo {
    public static void main(String[] args) throws Exception {
        //1. 注册驱动
        //MySQL5之后的jar包中给过了驱动，这里可以不写
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接
        //如果连接本机mysql并且端口号是3306，可以简写
        String url = "jdbc:mysql://127.0.0.1:3306/dbwork";
        String username = "root";
        String password = "pjl20031006";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql1 = "update yuanshen set preOrHan = 'Yes' where sno = 2128224000";
        String sql2 = "update yuanshen set preOrHan = 'Very' where sno = 2128224185";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        try {
            conn.setAutoCommit(false);

            //5. 执行sql
            int count1 = stmt.executeUpdate(sql1);//受影响的行数
            //6. 处理结果
            System.out.println(count1);
            //5. 执行sql
            int count2 = stmt.executeUpdate(sql2);//受影响的行数
            //6. 处理结果
            System.out.println(count2);

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        }

        //7. 释放资源
        stmt.close();//后开先关
        conn.close();//先开后关
    }
}
