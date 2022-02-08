package net.services.rating.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.services.rating.dao.Rating;
import net.services.rating.dao.RatingDao;

@WebServlet("/viewRatings")
public class RatingServlet extends HttpServlet {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewRatings.jsp");
        dispatcher.forward(request, response);
    

    

    }
}