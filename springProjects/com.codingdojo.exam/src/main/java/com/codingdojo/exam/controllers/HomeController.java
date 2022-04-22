package com.codingdojo.exam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.exam.models.LoginUser;
import com.codingdojo.exam.models.User;
import com.codingdojo.exam.services.ItemService;
import com.codingdojo.exam.services.UserService;


@Controller
public class HomeController {
	@Autowired
	private final UserService userSer;
	private final ItemService itemSer;
	
	public HomeController(UserService userSer,ItemService itemSer){
		super();
		this.userSer = userSer;
		this.itemSer = itemSer;
	}
	// ================================ GENERAL ================================
		@GetMapping("/")
		public String index(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				return "dashboard.jsp";
			}else {
				model.addAttribute("newUser", new User());
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}	
		}
		
		@GetMapping("/dashboard")
		public String dashboard(Model model, HttpSession session) {
			if(session.getAttribute("user_id") != null ) {
				Long loggedID = (Long) session.getAttribute("user_id");
				User userName = userSer.oneUser(loggedID);
//				List<Item> items = itemSer.allItems();
//				model.addAttribute("items",items);
				model.addAttribute("logged",userName);
				return "dashboard.jsp";
			}else {
				return "redirect:/";
			}
		}
		

		// ================================ LOGIN / REGISTRATION ================================
		@PostMapping("/api/register")
		public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result, Model model, HttpSession session) {
						
				userSer.register(newUser, result);
				
			if(result.hasErrors()) {
				model.addAttribute("newLogin", new LoginUser());
				return "index.jsp";
			}
						
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/dashboard";
		}
					
		@PostMapping("/api/login")
		public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
			User user = userSer.login(newLogin, result);
			if(result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "index.jsp";
			}
						
			session.setAttribute("user_id", user.getId());
			return "redirect:/dashboard";
		}
					
		@GetMapping("/logout")
		public String dashboard(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
		
		// ================================ ITEM ================================
		@GetMapping("/item/{id}")
		public String item(Model model,@PathVariable("id") Long id) {
			return "item.jsp";
		}
		
		@GetMapping("/add/item/{id}")
		public String addItem(Model model,@PathVariable("id") Long id) {
			return "addItem.jsp";
		}
		
		@DeleteMapping("/delete/item/{id}")
	    public String destroy(@PathVariable("id") Long id) {
			itemSer.deleteItem(id);
	        return "redirect:/dashboard";
	    }
		
}
