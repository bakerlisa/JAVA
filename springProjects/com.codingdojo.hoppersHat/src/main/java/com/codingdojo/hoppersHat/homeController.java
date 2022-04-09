package com.codingdojo.hoppersHat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "His Royal Highness Henry Happer Harriet Hemmingway the IVX";
        String itemName = "12 barrels of beer, 12 sozen bottels of wine, 6 wheels of cheese, 25lbs of grapes, and 5000crackers";
        String price = "2.5";
        String description = "Food for his royalness to eat on his week ling hunting trip";
        String vendor = "Brewery, Cheese Factory, Winery, and Cotton Keebler Factory";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name",name);
        model.addAttribute("itemName",itemName);
        model.addAttribute("price",price);
        model.addAttribute("description",description);
        model.addAttribute("vendor",vendor);
    
        return "index.jsp";
    }
    //...
    

}
