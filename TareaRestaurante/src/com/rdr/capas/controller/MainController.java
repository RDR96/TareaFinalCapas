package com.rdr.capas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.rdr.capas.domain.User;
import com.rdr.capas.repositories.UserRepository;
import com.rdr.capas.services.UserInterface;



@Controller
public class MainController {
	
	@Autowired
	private UserInterface userService;
	
	@RequestMapping("/")
	public ModelAndView initMain() {		
		ModelAndView mav = new ModelAndView();	
		
		User usuario = new User();
		
		
		mav.addObject("user", usuario);
		
		mav.setViewName("login");
		
		return mav;
	}	
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute User usuario, BindingResult result) {		
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors()) {
			
			mav.addObject("user", usuario);
			mav.setViewName("login");
			
			return "redirect:/";
		}
		
		List<User> usuarios = userService.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
		
		if (usuarios.size() == 1) {
			return "redirect:/branches";
		}else {
			mav.addObject("user", usuario);
			mav.addObject("message", "No existe el usuario");
			mav.setViewName("login");
		}
		
		return "redirect:/";
	}	
	
	
	
	
}
