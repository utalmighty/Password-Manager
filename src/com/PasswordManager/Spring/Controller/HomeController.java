package com.PasswordManager.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PasswordManager.Spring.Entity.Password;
import com.PasswordManager.Spring.Service.PasswordServiceInterface;

@Controller
public class HomeController {
	
	@Autowired
	PasswordServiceInterface databaseService;
	
	@GetMapping("/home")
	// Display all the URLs/Sites only
	public String getUrls(Model model) {
		List<String> urls = databaseService.getUrlPatterns();
		model.addAttribute("urls", urls);
		return "Home";
	}
	
	@GetMapping({"/addPassword", "/addpassword"})
	public String addPasswords(Model model) {
		model.addAttribute("title", "Add Password");
		model.addAttribute("Password", new Password());
		model.addAttribute("redirect", "added");
		return "password-form";
	}
	
	@PostMapping("/addedProcessPassword") // because this request is doing post request sending 
	// password object form browser to server using request body(not as url parameter).
	public String process(@ModelAttribute("Password") Password password) {
		// TODO: Add validation
		databaseService.addPassword(password);
		return "redirect:/home"; // This will redirect to home page
	}
	
	@GetMapping("/updatePassword")
	public String updatePassword(@RequestParam(name="id") int id, Model model) {
		Password password = databaseService.getPasswordById(id);
		if (password == null) {
			model.addAttribute("title", "Not found");
			model.addAttribute("Message", "Id not found or not valid.");
			return "error";
		}
		model.addAttribute("Password", password);
		model.addAttribute("title", "Update Password");
		model.addAttribute("redirect", "updated");
		return "password-form";
	}
	
	@PostMapping("/updatedProcessPassword")
	public String processUpdate(@ModelAttribute("Password") Password password) {
		// TODO: Add validation
		System.out.println(password);
		databaseService.updatePassword(password);
		return "redirect:/home";
	}
	
	@GetMapping("/deletePassword")
		public String deletePassword(@RequestParam(name="id") int id, Model model) {
			databaseService.deletePassword(id);
			return "processed";
	}
	
	@GetMapping("/passwords")
	public String getPasswordByUrlPattern(@RequestParam(name = "url") String url, Model model) {
		model.addAttribute("urlPattern", url);
		model.addAttribute("passwords", databaseService.getPasswordByUrl(url));
		return "list-password";
	}
	
}
