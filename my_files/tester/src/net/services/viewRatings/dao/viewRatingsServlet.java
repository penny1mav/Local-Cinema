package net.services.viewRatings.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.services.rating.dao.Rating;
import net.services.rating.dao.RatingDao;


@WebServlet("/viewRating")
public class viewRatingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RatingDao RateDao;

    public void init() {
        RateDao = new RatingDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        doGet(request, response);
    }

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	  List < Rating > listRate = RateDao.selectAllRatings();
          request.setAttribute("listRate", listRate);

          RequestDispatcher dispatcher = request.getRequestDispatcher("adminViewRatings.jsp");
          dispatcher.forward(request, response);
    }
}
