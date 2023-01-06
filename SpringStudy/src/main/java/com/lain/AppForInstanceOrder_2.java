package com.lain;

import com.lain.dao.OrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForInstanceOrder_2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextFactory.xml");

        OrderDao orderDao = (OrderDao) applicationContext.getBean("orderDao");

        orderDao.save();
    }
}
