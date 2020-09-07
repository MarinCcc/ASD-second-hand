package cn.second_hand.user.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.second_hand.user.domain.User;
import cn.second_hand.user.domain.UserException;
import cn.second_hand.user.service.UserService;
import cn.second_hand.user.utils.Mail;
import cn.second_hand.user.utils.MailUtils;

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
	public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		return "r:/login.jsp";
	}

	public  String register(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		User user = new User();
		user.setVerifyCode(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String repeatPwd = request.getParameter("confirmPwd");
		Map<String,String> map = new HashMap<String,String>();
		if(user.getEmail()==null||user.getEmail().trim().isEmpty()) {
			map.put("email", "Please enter an email address");
		}
		else if(!user.getEmail().matches("\\w+@\\w+\\.\\w+")) {
			map.put("email", "Enter a valid email address");
		}
		if(user.getPassword()==null||user.getPassword().trim().isEmpty()) {
			map.put("password", "Please enter your password");
		}
		else if(user.getPassword().length()<6 ) {
			map.put("password", "Please make password strong");
		}else if(user.getPassword().length()>16) {
			map.put("password", "Please make password weak");
		}
		if(!repeatPwd.equals(user.getPassword())) {
			map.put("repeatPwd", "Two passwords are not same");
		}
		
		if(!map.isEmpty()) {
			request.setAttribute("errors", map);
			request.setAttribute("user", user);
			request.setAttribute("confirmPwd", repeatPwd);
			return "f:/register.jsp";
		}
		
		try {

		userService.register(user);

		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			request.setAttribute("confirmPwd", repeatPwd);
			return "f:/register.jsp";
		}
		
		// add email verification at release 1
//		Properties pt = new Properties();
//		pt.load(UserServlet.class.getClassLoader().getResourceAsStream("email_template.properties"));
		String host = "smtp.163.com";
		String uname = "marin1113";
		String password = "CESUCIWLBOMGSXCA";
		String from = "marin1113@163.com";
		String to = user.getEmail();
		String subject =  "Confirm your account on Second-Hand-Market";
		String content = "<a href=\"http://localhost:8080/UserServlet?method=active&code={0}\">Click here to active your account</a>";
		content = MessageFormat.format(content, user.getVerifyCode());
		Session session = MailUtils.createSession(host, uname, password);
		Mail mail = new Mail(from,to,subject,content);
		try {
		
			MailUtils.send(session, mail);
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
//		request.setAttribute("msg", "Registration successfully!");
		
		request.setAttribute("msg", "Registered successfully, please check the activation information in the email");
		return "f:/msg.jsp";
	}
	
	public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		try {
			userService.active(code);	
			request.setAttribute("msg", "Congratulations, you can login your account right now！");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
		}
		return "f:/msg.jsp";
	}
	
	public  String login(HttpServletRequest request, HttpServletResponse response)    { 
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		try {
			User currentUser = userService.login(user);
			request.getSession().setAttribute("session_user", currentUser);
			return "r:/index.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			return "f:/login.jsp";
		}
	
	}
}
