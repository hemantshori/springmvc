package com.shori.springUsingDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvcUsingServlets.ErrorMessages;
import mvcUsingServlets.UserValidationService;

@Controller
public class LoginController {
@Autowired
	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String loginPage() {

		return "Login";
	}

	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	
	public String welcomePage(@RequestParam String name, ModelMap model,@RequestParam String password)
	{ 
		// matching logic
//		UserValidationService match = new UserValidationService();
//		Boolean isUserValid = match.validateUser(name, password);
		if(!UserValidationService.validateUser(name, password))
		{
			
				model.put("errorMessage", "Invalid Credentials");
				return "Login";
			}

			model.put("name", name);
			return "Welcome";
		
	}
}
