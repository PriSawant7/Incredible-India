package org.com.java;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.sessionbean.MailSenderBean;

/**
 * Servlet implementation class MailDispatcherServlet
 */
@WebServlet("/MailDispatcherServlet")
public class MailDispatcherServlet extends HttpServlet {

	@EJB
	MailSenderBean mailSender = new MailSenderBean();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailDispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("i am in maildespatcher servlet");
		String toemail = request.getParameter("toemail");

		String subject = request.getParameter("subject");

		String message = request.getParameter("message");

		// properties to be taken from database

		String fromEmail = "sawantpri72@gmail.com";
		String username = "sawantpri72@gmail.com";
		String password = "Pri@uncc792";

		// calling stateless session bean

		mailSender.sendEmail(fromEmail, username, password, toemail, subject, message);
	
		//response.sendRedirect("login.jsp");

	}

}
