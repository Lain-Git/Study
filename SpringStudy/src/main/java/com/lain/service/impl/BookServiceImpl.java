package com.lain.service.impl;

import com.lain.dao.BookDao;
import com.lain.dao.impl.BookDaoImpl;
import com.lain.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    public void save(){
        System.out.println("book service save ...");
        bookDao.save();
    }
}
