package com.lain;

import com.lain.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForName {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //若bean的别名不存在，将抛出异常NoSuchBeanDefinitionException
        BookService bookService = (BookService) applicationContext.getBean("service");

        bookService.save();
    }
}
