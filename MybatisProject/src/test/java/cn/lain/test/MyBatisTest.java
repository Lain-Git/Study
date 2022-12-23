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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
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
    public void testSelectById() throws IOException {
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
    public void testSelectByCondition() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        //数据库 % 和  _ 的作用，需自己手动完成
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        /*
        封装对象
        Brand brand = new Brand();
         brand.setStatus(status);
         brand.setCompanyName(companyName);
         brand.setBrandName(brandName);
        */

        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
//        map.put("brandName", brandName);

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
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        // List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        //数据库 % 和  _ 的作用，需自己手动完成
        //companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        Brand brand = new Brand();
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //Map map = new HashMap();
        //map.put("status", status);
        //map.put("companyName", companyName);
        //map.put("brandName", brandName);

        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        //List<Brand> brands = brandMapper.selectByCondition(map);
        //System.out.println(brands);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接受参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        /*默认开启事务，需手动提交sqlSession.commit()，设置为true，表示自动提交事务*/
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //5. 提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接受参数
        int status = 0;
        String companyName = "Steam";
        String brandName = "CSGO";
        String description = "一枪一个小朋友";
        int ordered = 60;
        int id = 12;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        /*默认开启事务，需手动提交sqlSession.commit()，设置为true，表示自动提交事务*/
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        int count = brandMapper.update(brand);
        System.out.println(count);

        //5. 提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        //接受参数
        int id = 12;

        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        /*默认开启事务，需手动提交sqlSession.commit()，设置为true，表示自动提交事务*/
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        brandMapper.deleteById(id);

        //5. 提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        //接受参数
        int[] ids = {13, 14, 15};

        //1. 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取sqlSession对象
        /*默认开启事务，需手动提交sqlSession.commit()，设置为true，表示自动提交事务*/
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        brandMapper.deleteByIds(ids);

        //5. 提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
    }
}
