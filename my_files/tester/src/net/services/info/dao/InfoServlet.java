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

import net.services.info.dao.Info;
import net.services.info.dao.InfoDao;

@WebServlet("/editInfo")
public class InfoServlet extends HttpServlet {
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
    	
        

   
        List < Info > listInfo = InfoDao.selectAllInfos();
        request.setAttribute("listInfo", listInfo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminInfo.jsp");
        dispatcher.forward(request, response);
    

    

    }
}