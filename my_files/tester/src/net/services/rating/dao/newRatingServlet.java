package net.services.rating.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.services.rating.dao.Rating;
import net.services.rating.dao.RatingDao;

/**
 * Servlet implementation class newRatingServlet
 */
@WebServlet("/newRating")
public class newRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RatingDao RatingDao;

    public void init() {
        RatingDao = new RatingDao();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generatingd method stub
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username= (String) request.getSession().getAttribute("username");
	        String comments = request.getParameter("comments");
	        System.out.println("username is:"+username);
	        
	        
	        Rating newRating = new Rating(username,comments);
	        try {
				RatingDao.insertRating(newRating);
			} catch (SQLException e) {
				// TODO Auto-generatingd catch block
				e.printStackTrace();
			}
	        RequestDispatcher dispatcher = request.getRequestDispatcher("newRating.jsp");
	        dispatcher.forward(request, response);	}

	

}
