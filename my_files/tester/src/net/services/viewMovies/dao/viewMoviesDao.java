package net.services.viewMovies.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.services.registration.moviemodel.Movie;


public class viewMoviesDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private static final String SELECT_MOVIES_BY_ID = "select id,movieTitle, movieDescr, movieViews,movieGenre from movies where id =?";

    private static final String SELECT_ALL_MOVIES = "select * from movies";


    public viewMoviesDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }



    public Movie selectMovie(int id) {
        Movie movie = null;
        
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIES_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String movieTitle = rs.getString("movieTitle");
                String movieDescr = rs.getString("movieDescr");
                String movieViews = rs.getString("movieViews");
                String movieGenre = rs.getString("movieGenre");
                
                movie = new Movie(id,movieTitle, movieDescr, movieViews,movieGenre);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return movie;
    }

    public List < Movie > selectAllMovies() {

    	
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Movie > movies = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                
                String movieTitle = rs.getString("movieTitle");
                String movieDescr = rs.getString("movieDescr");
                String movieViews = rs.getString("movieViews");
                String movieGenre = rs.getString("movieGenre");
                movies.add(new Movie(movieTitle, movieDescr, movieViews,movieGenre));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return movies;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}