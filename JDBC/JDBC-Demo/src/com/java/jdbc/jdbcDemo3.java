package com.java.jdbc;

import java.sql.*;

/**
 * SQLע����ʾ
 */
public class jdbcDemo3 {
    public static void main(String[] args) throws Exception {
        //��ȡ����
        //������ӱ���mysql���Ҷ˿ں���3306�����Լ�д
        String url = "jdbc:mysql://127.0.0.1:3306/dbwork";
        String username = "root";
        String password = "pjl20031006";
        Connection conn = DriverManager.getConnection(url, username, password);
        //�����û����� �û���������
        String name = "panjinlai";
        String pwd = "'or'1'='1";

        String sql = "select * from account where username = '"+name+"' and userpassword = '"+pwd+"'";
        System.out.println(sql);

        //��ȡstmt����
        Statement stmt = conn.createStatement();

        //ִ��sql
        ResultSet rs = stmt.executeQuery(sql);

        //�жϵ�¼�Ƿ�ɹ�
        if(rs.next()) {
            System.out.println("��¼�ɹ�");
        }else {
            System.out.println("��¼ʧ��");
        }

        //7. �ͷ���Դ
        rs.close();
        stmt.close();//���ȹ�
        conn.close();//�ȿ����
    }
}
