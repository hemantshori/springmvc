package mvcUsingServlets;

import org.springframework.stereotype.Service;

@Service
public class ErrorMessages {

	
	public String loginFailErrorMessage()
	{
		String message = "Incorrect UserName/Password, Please enter a correct combination";
		return message;
	}
}
