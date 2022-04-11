package com.codingdojo.ninjaGold.controller;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ninjaGold.models.Action;

@Controller
public class gold {
	private ArrayList<Action> actions = new ArrayList<Action>(); 
	
	@RequestMapping("/gold")
	 public String index(HttpSession session, Model model) {
	if (session.getAttribute("prision") == "true") {
		return "redirect:/prision";
	}else if (session.getAttribute("gold") == null) {
			 session.setAttribute("gold", 0);
			 model.addAttribute("gold", 0);
		}else {
			Integer goldCount = (Integer) session.getAttribute("gold");
			if(goldCount < 0) {
				return "redirect:/prision";
			}
			model.addAttribute("gold", goldCount);
		}
		
		model.addAttribute("actionsMade", actions);
	
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
		
		if(goldRecieved > 0) {
			actions.add(new Action("negative", goldRecieved, actionType));
		}else {
			actions.add(new Action("positive", goldRecieved, actionType));
		}

		session.setAttribute("gold", totalGold);
	
		return "redirect:/gold";
	 }
	
	@RequestMapping("/reset")
	 public String reset(HttpSession session, Model model) {
		session.setAttribute("gold", 0);
		actions = new ArrayList<Action>(); 
		
		return "redirect:/gold";
	 }
	
	@RequestMapping("/restart")
	 public String restart(HttpSession session, Model model) {
		session.setAttribute("gold", 0);
		actions = new ArrayList<Action>(); 
		session.setAttribute("prision", "false");
		
		return "redirect:/gold";
	 }
	
	@RequestMapping("/prision")
	 public String prision(HttpSession session, Model model) {
		session.setAttribute("gold", 0);
		session.setAttribute("prision", "true");
		actions = new ArrayList<Action>(); 
		
		return "prision.jsp";
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
		if(actionType.equals("spa")) {
			randInt *= -1;
		}
		return randInt;
	}
	
}
