package com.java.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.java.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增、删、改、查操作
 */
public class BrandDemo {

    public void testSelectAll() throws Exception {

        /**
         * 查询所有
         * 1. SQL：select * from tb_brand
         * 2. 参数：不需要
         * 3. 结果：List<Brand>
         */

        //1. 获取Connection
        /*加载配置文件*/
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/IDEA/Projects/JDBC/JDBC-Demo/src/druid.properties"));
        /*获取连接池对象*/
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        /*获取数据库连接*/
        Connection conn = dataSource.getConnection();

        //2. 定义SQL语句
        String sql = "select * from tb_brand";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数

        //5. 执行SQL
        ResultSet rs = pstmt.executeQuery();

        //6. 处理结果集List<Brand>，封装Brand对象，装载List集合
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while (rs.next()) {

            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //封装Brand对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            //装载入集合中
            brands.add(brand);
        }

        System.out.println(brands);

        //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    public void testAdd() throws Exception {

        /**
         * 增加
         * 1. SQL：insert into tb_brand(brand_name, company_name, ordered, description, status) values(?, ?, ?, ?, ?)
         * 2. 参数：需要，除了id之外的所有参数
         * 3. 结果：boolean
         */

        //接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘股份有限公司";
        int ordered = 1;
        String description = "十里飘香";
        int status = 1;

        //1. 获取Connection
        /*加载配置文件*/
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/IDEA/Projects/JDBC/JDBC-Demo/src/druid.properties"));
        /*获取连接池对象*/
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        /*获取数据库连接*/
        Connection conn = dataSource.getConnection();

        //2. 定义SQL语句
        String sql = "insert into " +
                "tb_brand(brand_name, company_name, ordered, description, status) " +
                "values(?, ?, ?, ?, ?)";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

        //5. 执行SQL
        int count = pstmt.executeUpdate();

        //处理结果
        System.out.println(count > 0);

        //7. 释放资源
        pstmt.close();
        conn.close();
    }

    public void testUpdate() throws Exception {

        /**
         * 修改
         * 1. SQL：update tb_brand set brand_name = ?,
         company_name = ?,
         ordered = ?,
         description = ?,
         status = ? where id = ?
         * 2. 参数：需要，Brand对象所有数据
         * 3. 结果：boolean
         */

        //接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘股份有限公司";
        int ordered = 185;
        String description = "百里飘香";
        int status = 1;
        int id = 4;

        //1. 获取Connection
        /*加载配置文件*/
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/IDEA/Projects/JDBC/JDBC-Demo/src/druid.properties"));
        /*获取连接池对象*/
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        /*获取数据库连接*/
        Connection conn = dataSource.getConnection();

        //2. 定义SQL语句
        String sql = "update tb_brand set brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ? where id = ?";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        //5. 执行SQL
        int count = pstmt.executeUpdate();

        //处理结果
        System.out.println(count > 0);

        //7. 释放资源
        pstmt.close();
        conn.close();
    }

    public void testDeleteById() throws Exception {

        /**
         * 删除
         * 1. SQL：delete from tb_brand where id = ?
         * 2. 参数：需要，id
         * 3. 结果：boolean
         */

        //接收页面提交的参数
        int id = 4;

        //1. 获取Connection
        /*加载配置文件*/
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:/IDEA/Projects/JDBC/JDBC-Demo/src/druid.properties"));
        /*获取连接池对象*/
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        /*获取数据库连接*/
        Connection conn = dataSource.getConnection();

        //2. 定义SQL语句
        String sql = "delete from tb_brand where id = ?";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setInt(1, id);

        //5. 执行SQL
        int count = pstmt.executeUpdate();

        //处理结果
        System.out.println(count > 0);

        //7. 释放资源
        pstmt.close();
        conn.close();
    }

}
