package com.java.jdbc;

import java.sql.*;

/**
 * 防止SQL注入——PreparedStatement
 */
public class jdbcDemo4_PreparedStatement {
    public static void main(String[] args) throws Exception {
        //获取连接
        //如果连接本机mysql并且端口号是3306，可以简写
        // useServerPrepStmts=true 添加此参数开启预编译功能
        String url = "jdbc:mysql://127.0.0.1:3306/dbwork?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "pjl20031006";
        Connection conn = DriverManager.getConnection(url, username, password);
        //接收用户输入 用户名和密码
        String name = "panjinlai";
        String pwd = "2128224185";

        //定义sql
        String sql = "select * from account where username = ? and userpassword = ?";

        //获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置？的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //执行sql
        ResultSet rs = pstmt.executeQuery();

        //判断登录是否成功
        if(rs.next()) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        //7. 释放资源
        rs.close();
        pstmt.close();//后开先关
        conn.close();//先开后关
    }
}
