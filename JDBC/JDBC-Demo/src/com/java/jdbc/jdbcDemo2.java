package com.java.jdbc;

import com.java.pojo.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC
 */
public class jdbcDemo2 {
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
        String sql = "select * from course";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);//受影响的行数
        //创建集合
        List<Account> list = new ArrayList<>();
        //6. 处理结果
        while (rs.next()) {
            Account account = new Account();
            //获取数据
            int cno = rs.getInt(1);
            String cname = rs.getString(2);
            String ccredit = rs.getString(3);

            //赋值
            account.setCno(cno);
            account.setCname(cname);
            account.setCcredit(ccredit);

            //存入集合
            list.add(account);
        }

        System.out.println(list);

        //7. 释放资源
        rs.close();
        stmt.close();//后开先关
        conn.close();//先开后关
    }
}
