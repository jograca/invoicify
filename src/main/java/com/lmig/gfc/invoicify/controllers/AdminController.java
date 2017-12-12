package com.lmig.gfc.invoicify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

	public AdminController() {

	}

	@GetMapping("")
	public ModelAndView showDefaultPage() {
		ModelAndView mv = new ModelAndView("admin/default");
		return mv;
	}

}
