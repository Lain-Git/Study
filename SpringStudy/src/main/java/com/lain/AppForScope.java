package com.lain;

import com.lain.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForScope {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Spring默认创建的bean对象是一个单例（地址相同）
        //若创建非单例的bean，需要进行配置
        BookService bookService1 = (BookService) applicationContext.getBean("bookService");
        BookService bookService2 = (BookService) applicationContext.getBean("bookService");
        System.out.println(bookService1);
        System.out.println(bookService2);
    }
}
