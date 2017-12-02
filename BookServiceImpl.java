package com.bear.bookonline.book.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.bear.bookonline.book.dao.BookDaoImpl;
import com.bear.bookonline.entity.Book;

@Service
@Transactional(readOnly=true)
public class BookServiceImpl {
	
	@Resource
	private BookDaoImpl bookDaoImpl;
	
	public List<Book> listAll(){
		return this.bookDaoImpl.findAll();
	}
}
