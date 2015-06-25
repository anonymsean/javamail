package cn.sean.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sean.db.DBFactory;
import cn.sean.db.EmailDAO;
import cn.sean.db.EmailDTO;
import cn.sean.db.UserDAO;
import cn.sean.db.UserDTO;
import cn.sean.mail.MailManager;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String url=req.getServletPath();
		if(url.toUpperCase().indexOf("USERLOGIN")!=-1){
			//��¼�ʼ�ϵͳ
			UserDTO userDTO=new UserDTO();
			userDTO.setUserid(req.getParameter("txtUserID"));
			userDTO.setPassword(req.getParameter("pwdUserPWD"));
			
			Connection conn=DBFactory.getConnection();
			UserDAO  userDAO=new UserDAO();
			if(userDAO.findUser(userDTO, conn)){
				req.getSession().setAttribute("userinfo", userDTO);
				MailManager mm=new MailManager();
				mm.setUser(userDTO.getUserid());
				mm.setPassword(userDTO.getPassword());
				if(mm.receiveMail()){
					EmailDTO emailDTO=new EmailDTO();
					emailDTO.setUserID(userDTO.getUserid());
					List<EmailDTO> mailList=new EmailDAO().getMailList(emailDTO, conn);
					req.getSession().setAttribute("emailList", mailList);
				}
				DBFactory.closeConnection(conn);
				url="main.jsp";
			}else{
				url="err.jsp";
			}
		}else if(url.toUpperCase().indexOf("LOGOUT")!=-1){
			req.getSession().invalidate();
			url="index.jsp";
		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
}
