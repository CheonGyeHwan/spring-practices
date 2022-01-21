package com.poscoict.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscoict.emaillist.repository.EmaillistRepository;
import com.poscoict.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	@Autowired
	private EmaillistRepository emaillistRepository;

	@ResponseBody
	@RequestMapping("")
	public String index() {
		System.out.println(emaillistRepository);
		// List<EmaillistVo> list = new EmaillistRepository().findAll();
		
		
		return "Emaillist";
	}
	
}
