package net.services.info.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.services.info.dao.Info;
import net.services.info.dao.InfoDao;

@WebServlet("/newInfo")
public class newInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InfoDao InfoDao;

    public void init() {
        InfoDao = new InfoDao();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String title = request.getParameter("title");
	        String descr = request.getParameter("descr");
	        System.out.println("title is:"+title);
	        
	        
	        Info newInfo = new Info(title,descr);
	        try {
				InfoDao.insertInfo(newInfo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        RequestDispatcher dispatcher = request.getRequestDispatcher("newInfo.jsp");
	        dispatcher.forward(request, response);	}

	


}
