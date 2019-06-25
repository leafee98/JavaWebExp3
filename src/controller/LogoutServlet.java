package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("�û��ǳ���"+request.getSession().getAttribute("Username"));
		request.getSession().invalidate();
		response.sendRedirect("/JavaWebExp3/userlogin.html");
	}

}
