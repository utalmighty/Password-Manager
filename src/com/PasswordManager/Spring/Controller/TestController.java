package com.PasswordManager.Spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class TestController {
	
	@RequestMapping("/test")
	public String test(Model model) {
		return "Test";
	}
}
