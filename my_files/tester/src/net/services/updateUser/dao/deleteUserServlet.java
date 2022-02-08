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

import net.services.registration.moviedao.MovieDao;
import net.services.registration.moviemodel.Movie;

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private deleteUserDao deleteUserDao;

	    public void init() {
	        deleteUserDao = new deleteUserDao();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    	
	        

	    

	    
	  
			String username= (String) request.getSession().getAttribute("username");
			System.out.println("username is:" +username);
	        try {
				deleteUserDao.deleteUser(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	        dispatcher.forward(request, response);

	    

}
}