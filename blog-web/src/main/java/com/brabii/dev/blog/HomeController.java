package com.brabii.dev.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public HomeController() {
		System.out.println("============ home controller bean =============");
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
