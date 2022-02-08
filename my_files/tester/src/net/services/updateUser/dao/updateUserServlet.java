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


@WebServlet("/updateName")
public class updateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private updateUserDao updateUserDao;

    public void init() {
        updateUserDao = new updateUserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        doGet(request, response);
    }

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
		String oldusername= (String) request.getSession().getAttribute("username");
        String newusername = request.getParameter("username");
	        try {
				updateUserDao.updateUser(oldusername,newusername);
        		request.getSession().setAttribute("username", newusername);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
        dispatcher.forward(request, response);
    }
        
    }

  
    
   

   

    
