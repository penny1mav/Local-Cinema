package net.services.info.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Info {
    protected int id;
    protected String title;
    protected String descr;




    public Info() {}

    public Info(String title, String descr) {
        super();
        this.title = title;
        this.descr = descr;
       
    }
    public Info(int id,String title, String descr) {
        super();
        this.title = title;
        this.descr = descr;
       
        this.id = id;
    }
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

    
}
