package com.lain;

import com.lain.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_2_1 {
    public static void main(String[] args) {

        //第一步在pom.xml文件中完成（导入Spring坐标）

        //第二步在applicationContext.xml文件中完成（配置bean）

        //拿bean首先要拿容器

        //3. 获取IoC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //4. 获取bean（参数为配置bean时的参数）
        /*有返回值的，是一个对象，类型从Object改为BookDao，强制类型转换*/
        BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");

        //5. 取到bean对象之后就可以使用了
        bookDao.save();
    }
}