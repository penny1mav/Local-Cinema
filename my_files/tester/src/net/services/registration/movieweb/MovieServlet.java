package net.services.registration.movieweb;

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


@WebServlet("/")
public class MovieServlet extends HttpServlet {
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
    	
        String action = request.getServletPath();
        System.out.println("action is:"+action);
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertMovie(request, response);
                    break;
                case "/delete":
                    deleteMovie(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateMovie(request, response);
                    break;
                default:
                    listMovie(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Movie > listMovie = MovieDao.selectAllMovies();
        request.setAttribute("listMovie", listMovie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie existingMovie = MovieDao.selectMovie(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("movie", existingMovie);
        dispatcher.forward(request, response);

    }

    private void insertMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String movieTitle = request.getParameter("movieTitle");
        String movieDescr = request.getParameter("movieDescr");
        String movieViews = request.getParameter("movieViews");
        String movieGenre = request.getParameter("movieGenre");
        
        
        Movie newMovie = new Movie(movieTitle, movieDescr, movieViews,movieGenre);
        MovieDao.insertMovie(newMovie);
        response.sendRedirect("list");
    }

    private void updateMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String movieName = request.getParameter("movieTitle");
        String movieDescr = request.getParameter("movieDescr");
        String movieViews = request.getParameter("movieViews");
        String movieGenre = request.getParameter("movieGenre");
        
        Movie book = new Movie(id, movieName, movieDescr, movieViews,movieGenre);
        MovieDao.updateMovie(book);
        response.sendRedirect("list");
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MovieDao.deleteMovie(id);

        response.sendRedirect("list");

    }
}