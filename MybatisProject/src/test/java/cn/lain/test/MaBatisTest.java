package cn.lain.test;

import cn.lain.mapper.BrandMapper;
import cn.lain.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MaBatisTest {
    @Test
    public void teatSelectAll() throws IOException {
        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void teatSelectById() throws IOException {
        //接受参数
        int id = 1;

        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void teatSelectByCondition() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }
}
