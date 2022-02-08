package net.services.viewMovies.dao;

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


@WebServlet("/viewMovies")
public class viewMoviesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MovieDao MovieDao;

    public void init() {
        MovieDao = new MovieDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        doGet(request, response);
    }

    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	  List < Movie > listMovie = MovieDao.selectAllMovies();
          request.setAttribute("listMovie", listMovie);
          RequestDispatcher dispatcher = request.getRequestDispatcher("availableMovies.jsp");
          dispatcher.forward(request, response);
    }
    

  
    
   

   

    
}