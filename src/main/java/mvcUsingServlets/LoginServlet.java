package mvcUsingServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		UserValidationService validate = new UserValidationService();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		 Boolean isUserValid = validate.validateUser(name,password);
		
		if(isUserValid)
		{
			
			request.setAttribute("name", name);

			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
		}else{
			ErrorMessages errorMessage = new ErrorMessages();
			String message = errorMessage.loginFailErrorMessage();
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}
		
	}

}
