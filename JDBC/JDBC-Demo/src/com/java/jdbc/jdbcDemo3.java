package com.java.jdbc;

import java.sql.*;

/**
 * SQL注入演示
 */
public class jdbcDemo3 {
    public static void main(String[] args) throws Exception {
        //获取连接
        //如果连接本机mysql并且端口号是3306，可以简写
        String url = "jdbc:mysql://127.0.0.1:3306/dbwork";
        String username = "root";
        String password = "pjl20031006";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入 用户名和密码
        String name = "panjinlai";
        String pwd = "'or'1'='1";

        String sql = "select * from account where username = '"+name+"' and userpassword = '"+pwd+"'";
        System.out.println(sql);

        //获取stmt对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);

        //判断登录是否成功
        if(rs.next()) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        //7. 释放资源
        rs.close();
        stmt.close();//后开先关
        conn.close();//先开后关
    }
}
