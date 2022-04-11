package com.codingdojo.ninjaGold.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class gold {
	 
	@RequestMapping("/gold")
	 public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			 session.setAttribute("gold", 0);
			 model.addAttribute("gold", 0);
		}else {
			Object goldCount = session.getAttribute("gold");
			model.addAttribute("gold", goldCount);
		}
	     return "index.jsp";
	 }
	
	@RequestMapping("/findGold")
	 public String flashMessages(HttpSession session,
			 @RequestParam(value="min") Integer max,
			  @RequestParam(value="max") Integer min,
			  @RequestParam(value="type") String type) {
		Integer goldCount = (Integer) session.getAttribute("gold");
		
		session.setAttribute("max", max);
		session.setAttribute("min", min);
		session.setAttribute("type", type);
		session.setAttribute("gold", goldCount);
		
		return "redirect:/countGold";
	 }
	
	@RequestMapping("/countGold")
	 public String countGold(HttpSession session, Model model) {
		
		Integer maxNum = (Integer) session.getAttribute("max");
		Integer minNum = (Integer) session.getAttribute("min");
		String actionType = (String) session.getAttribute("type");
		Integer goldCount = (Integer) session.getAttribute("gold");
		
		int goldRecieved = radnomNumber(maxNum,minNum,actionType);
		int totalGold = goldCount + goldRecieved;
		
		session.setAttribute("gold", totalGold);
		model.addAttribute("gold", totalGold);

		return "redirect:/gold";
	 }
	
	public int radnomNumber(int maxGold, int minGold, String actionType) {
		Random rand = new Random();
		int low = minGold;
		int high = maxGold;
		int randInt = rand.nextInt(high-low) + low;
		
		if(actionType.equals("quest")) {
			if(randInt % 2 == 0) {
				System.out.println("here");
				randInt *= -1;
			}
		}
		return randInt;
	}
	
}
