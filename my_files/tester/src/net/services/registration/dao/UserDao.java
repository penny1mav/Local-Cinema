package net.services.registration.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.services.registration.model.User;

public class UserDao {
	 public int registerUser(User user) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO users" +
	            "  (id, first_name, last_name,email, username, password) VALUES " +
	            " (?, ?, ?, ?, ?,?);";

	        int result = 0;
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/cinema?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true", "root", "1234");
	        		
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, user.getId());
	            preparedStatement.setString(2, user.getFirstName());
	            preparedStatement.setString(3, user.getLastName());
	            preparedStatement.setString(4, user.getEmail());
	            preparedStatement.setString(5, user.getUsername());
	            preparedStatement.setString(6, user.getPassword());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();
	           
	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
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
