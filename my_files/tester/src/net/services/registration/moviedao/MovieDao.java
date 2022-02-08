package net.services.registration.moviedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.services.registration.moviemodel.Movie;


public class MovieDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private static final String INSERT_MOVIES_SQL = "INSERT INTO movies" + "  (movieTitle, movieDescr, movieViews,movieGenre) VALUES " +
        " ( ?, ?, ?,?);";
    private static final String SELECT_MOVIES_BY_ID = "select id,movieTitle, movieDescr, movieViews,movieGenre from movies where id =?";
    private static final String SELECT_ALL_MOVIES = "select * from movies";
    private static final String DELETE_MOVIES_SQL = "delete from movies where id = ?;";
    private static final String UPDATE_MOVIES_SQL = "update movies set movieTitle=?, movieDescr=?, movieViews=?, movieGenre=?;";

    public MovieDao() {}

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

    public void insertMovie(Movie movie) throws SQLException {
        System.out.println(INSERT_MOVIES_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIES_SQL)) {
        	preparedStatement.setString(1, movie.getMovieTitle());
            preparedStatement.setString(2, movie.getMovieDescr());
            preparedStatement.setString(3, movie.getMovieViews());
            preparedStatement.setString(4, movie.getMovieGenre());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
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
                int id = rs.getInt("id");
                String movieTitle = rs.getString("movieTitle");
                String movieDescr = rs.getString("movieDescr");
                String movieViews = rs.getString("movieViews");
                String movieGenre = rs.getString("movieGenre");
                movies.add(new Movie(id,movieTitle, movieDescr, movieViews,movieGenre));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return movies;
    }

    public boolean deleteMovie(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_MOVIES_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateMovie(Movie movie) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_MOVIES_SQL);) {
            statement.setString(1, movie.getMovieTitle());
            statement.setString(2, movie.getMovieDescr());
            statement.setString(3, movie.getMovieViews());
            statement.setString(4, movie.getMovieGenre());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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