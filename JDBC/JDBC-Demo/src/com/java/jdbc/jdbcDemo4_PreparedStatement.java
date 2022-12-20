package com.java.jdbc;

import java.sql.*;

/**
 * ��ֹSQLע�롪��PreparedStatement
 */
public class jdbcDemo4_PreparedStatement {
    public static void main(String[] args) throws Exception {
        //��ȡ����
        //������ӱ���mysql���Ҷ˿ں���3306�����Լ�д
        // useServerPrepStmts=true ��Ӵ˲�������Ԥ���빦��
        String url = "jdbc:mysql://127.0.0.1:3306/dbwork?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "pjl20031006";
        Connection conn = DriverManager.getConnection(url, username, password);
        //�����û����� �û���������
        String name = "panjinlai";
        String pwd = "2128224185";

        //����sql
        String sql = "select * from account where username = ? and userpassword = ?";

        //��ȡPreparedStatement����
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //���ã���ֵ
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        //ִ��sql
        ResultSet rs = pstmt.executeQuery();

        //�жϵ�¼�Ƿ�ɹ�
        if(rs.next()) {
            System.out.println("��¼�ɹ�");
        }else {
            System.out.println("��¼ʧ��");
        }

        //7. �ͷ���Դ
        rs.close();
        pstmt.close();//���ȹ�
        conn.close();//�ȿ����
    }
}
