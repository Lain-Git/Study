package com.lain;

import com.lain.dao.OrderDao;
import com.lain.factory.OrderDaoFactory;

public class AppForInstanceOrder_1 {
    public static void main(String[] args) {
        //通过静态工厂创建对象

        //使用静态工厂获得对象，再运行
        OrderDao orderDao = OrderDaoFactory.getOrderDao();
        orderDao.save();
    }
}
