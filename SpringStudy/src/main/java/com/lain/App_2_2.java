package com.lain;

import com.lain.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_2_2 {
    public static void main(String[] args) {
        //获取IoC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        //使用bean
        bookService.save();
    }
}
