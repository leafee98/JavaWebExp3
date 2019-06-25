package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dataobject.Paper;
import dataobject.User;


public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//��ȡ������
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("input_username");
		String password = request.getParameter("input_password");
		String nickname = request.getParameter("input_nickname");
		System.out.println(username+"\r\n"+password+"\r\n"+nickname);

		//����û��������Ƿ���ȷ
		UserDao userDao = new UserDao();
		boolean res = userDao.addUser(username, password, nickname, true);
		
		if(!res) //����ȷ���ض�������¼ҳ��
			response.sendRedirect("/JavaWebExp3/registerfailed.html");
		else //��ȷ��������ݿ����������û���ҳ
		{
			request.getSession().setAttribute("Username", username);
			request.getSession().setAttribute("Password", password);
			User user = userDao.getUser();
			List<Paper> list = userDao.getAllowedPaper();
			request.getSession().setAttribute("User", user);
			request.getSession().setAttribute("PaperList", list);
			request.getRequestDispatcher("/WEB-INF/user_main.jsp").forward(request, response);
		}
	}

}
