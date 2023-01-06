package com.lain;

import com.lain.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceBook {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextInstance.xml");

        BookDao bookDao = (BookDao) applicationContext.getBean("bookDao");

        bookDao.save();
    }
}
