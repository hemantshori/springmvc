package mvcUsingServlets;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserValidationService {

	
	
		public static boolean validateUser(String user, String password) {
			
			return user.equalsIgnoreCase("hemant") && password.equals("hemant");
		}

	
}