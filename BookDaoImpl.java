package com.bear.bookonline.book.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bear.bookonline.entity.Book;

@Repository
public class BookDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Book> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Book");
		return q.list();
	}
}
