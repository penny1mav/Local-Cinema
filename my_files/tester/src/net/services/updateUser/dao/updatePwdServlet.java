package net.services.updateUser.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.services.registration.dao.UserDao;
import net.services.registration.model.User;
import net.services.registration.moviemodel.Movie;


@WebServlet("/updatePassword")
public class updatePwdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private updatePwdDao updatePwdDao;

    public void init() {
    	updatePwdDao = new updatePwdDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        doGet(request, response);
    }

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
		String username= (String) request.getSession().getAttribute("username");
        String oldPassword= request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
		String password= (String) request.getSession().getAttribute("password");
        System.out.println("new Password is " +newPassword);
        System.out.println("old Password writen is " +oldPassword);

		if(oldPassword.equals(password)) {
        
	        try {
	        	updatePwdDao.updatePassword(username,newPassword);
		        System.out.println("new password: " +newPassword);
        		request.getSession().setAttribute("password", newPassword);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
        dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("changePwd.jsp");
	        System.out.println("saved password is : " +password);
	        dispatcher.forward(request, response);
		}
    }
        
    }

  
    
   

   

    
