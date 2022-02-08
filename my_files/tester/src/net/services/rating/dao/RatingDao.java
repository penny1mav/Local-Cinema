package net.services.rating.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.services.rating.dao.Rating;

public class RatingDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private static final String INSERT_INFOS_SQL = "INSERT INTO ratings" + "  (username, comments) VALUES " +
        " ( ?, ?);";
    private static final String SELECT_ALL_INFOS = "select * from ratings";

    public RatingDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generatingd catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generatingd catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertRating(Rating rating) throws SQLException {
        System.out.println(INSERT_INFOS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INFOS_SQL)) {
        	preparedStatement.setString(1, rating.getUsername());
            preparedStatement.setString(2, rating.getComments());
        
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    

    public List < Rating > selectAllRatings() {

    	
        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Rating > ratings = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INFOS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String comments = rs.getString("comments");
               
                ratings.add(new Rating(id,username, comments));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ratings;
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