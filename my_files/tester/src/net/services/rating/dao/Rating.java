package net.services.rating.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rating {
    protected int id;
    protected String username;
    protected String comments;

    


    public Rating() {}

    public Rating(String username, String comments) {
        super();
        this.username = username;
        this.comments = comments;
       
    }
    public Rating(int id,String username, String comments) {
        super();
        this.username = username;
        this.comments = comments;
       
        this.id = id;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

    
}
