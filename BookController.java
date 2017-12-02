package com.bear.bookonline.book.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bear.bookonline.book.service.BookServiceImpl;
import com.bear.bookonline.entity.Book;

@Controller
@RequestMapping("book")
public class BookController {
	
	@Resource
	private BookServiceImpl bookServiceImpl;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Book> list = this.bookServiceImpl.listAll();
		model.addAttribute("list",list);
		return "list";
	}
}
