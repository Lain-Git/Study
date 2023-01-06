package com.lain.dao.impl;

import com.lain.dao.BookDao;

public class BookDaoImpl implements BookDao {
    //Spring创建bean同样是使用构造方法创建的
    //构造方法更换为private访问修饰加强印证
    //私有可访问，底层为反射机制

    //Spring创建bean时，调用的是无参构造器
    //无参构造器若不存在，将抛出异常BeanCreationException
    private BookDaoImpl() {
        System.out.println("book dao constructor is running...");
    }

    public void save() {
        System.out.println("book dao save ...");
    }
}
