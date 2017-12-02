package com.bear.bookonline.user.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.bookonline.entity.User;
import com.bear.bookonline.user.service.UserRegistServiceImpl;

@Controller
@RequestMapping("user")
public class UserRegistController {
	
	@Resource
	private UserRegistServiceImpl userRegistServiceImpl;
	
	@RequestMapping("/saveuser")
	public String addUser(Model model,User user,@RequestParam("username") String name,@RequestParam("userpwd") String pwd,
			@RequestParam("usertelephone") String tel,@RequestParam("useraddress") String address,
			@RequestParam("useremail") String email,@RequestParam("usernum") String num) {
		List<User> userList = this.userRegistServiceImpl.listAll();
		for(int i = 0 ;i < userList.size();i++) {
			if(((userList.get(i)).getUsername()).equals(name)) {
				return null;
			}
		}
		user.setUsername(name);
		user.setUserpwd(pwd);
		user.setTelephone(tel);
		user.setAddress(address);
		user.setEmail(email);
		user.setUsernum(num);
		this.userRegistServiceImpl.saveUser(user);
		model.addAttribute("user",user);
		return "index";
	}
}
