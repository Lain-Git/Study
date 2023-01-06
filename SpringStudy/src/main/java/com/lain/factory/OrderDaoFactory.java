package com.lain.factory;

import com.lain.dao.OrderDao;
import com.lain.dao.impl.OrderDaoImpl;

public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }
}
