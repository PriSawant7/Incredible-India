package org.com.java;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.java.dao.UserDao;
import org.com.java.dto.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url = "/index.jsp";

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();

		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setUsername(request.getParameter("userName"));
		UserDao dao = new UserDao();
		dao.checkUserName(user);
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));

		dao.insertUser(user);
		response.sendRedirect("login.jsp");

	}

}
