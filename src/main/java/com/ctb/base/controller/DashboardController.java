package com.ctb.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DashboardController {

	@GetMapping("/")
	public String index() {
		return "<h1>Sananas</h1>";
	}
}
