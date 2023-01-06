package com.lain.service.impl;

import com.lain.dao.BookDao;
import com.lain.dao.impl.BookDaoImpl;
import com.lain.service.BookService;

public class BookServiceImpl implements BookService {
    //5. 删除业务层中使用new方式创建的对象
    private BookDao bookDao;

    public void save(){
        System.out.println("book service save ...");
        bookDao.save();
    }

    //6. 提供对应的set方法（容器在执行这个set方法）

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
