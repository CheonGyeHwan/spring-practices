package com.poscoict.helloweb.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {
		System.out.println("name : " + name);
		return "/WEB-INF/views/hello2.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		
		return mav;
	}
	
	/* 추천 */
	@RequestMapping("/hello4")
	public String hello4(String id, Model model) {
		model.addAttribute("id", id);
		return "/WEB-INF/views/hello4.jsp";
	}
	
	
	@RequestMapping("/hello5")
	public String hello5() {
		return "redirect:/hello";
	}
	
	
	@ResponseBody
	@RequestMapping("/hello6")
	public String hello6() {
		return "<h1>Hello World</h1>";
	}
	
	
	/* 절대 비추(기술 침투) */
	@RequestMapping("/hello7")
	public void hello7(
			HttpServletRequest req,
			HttpServletResponse res,
			HttpSession session,
			Writer out) throws IOException {
		String id = req.getParameter("id");
		out.write("<h1>Hello " + id + "</h>");
	}
}
