package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("un");
		String password=req.getParameter("pwd");
		
		if(userName.equals("admin") && password.equals("admin")) {
		HttpSession session	=req.getSession();
		session.setAttribute("ABC", 5);
		req.getSession().setMaxInactiveInterval(10);
		resp.getWriter().print("<h1 style='color:green'>Login Success </h1> ");
		req.getRequestDispatcher("home.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1 style='color:red'> Invalid Credentials </h1>" );
			req.getRequestDispatcher("Login.html").include(req, resp);
			
		}
		
	}

}
