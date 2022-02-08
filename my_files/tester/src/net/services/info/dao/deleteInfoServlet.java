package net.services.info.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteInfo")
public class deleteInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfoDao InfoDao;

    public void init() {
        InfoDao = new InfoDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        

   
    	int id = Integer.parseInt(request.getParameter("id"));
        try {
			InfoDao.deleteInfo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("editInfo");
        dispatcher.forward(request, response);

    

    }
}
