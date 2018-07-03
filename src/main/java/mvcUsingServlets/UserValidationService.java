package mvcUsingServlets;

public class UserValidationService {

	
	public Boolean validateUser(String userName, String password)
	{
		if(userName.equals("hemant")&& password.equals("hemant"))
		
			return true;

	return false;
}
	
}