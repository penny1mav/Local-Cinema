package net.services.login.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.services.login.bean.LoginBean;
import net.services.login.database.loginDao;


@WebServlet("/home")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private loginDao loginDao;

    public void init() {
        loginDao = new loginDao();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
			
    		Object username= request.getSession().getAttribute("username");
    		if(username.equals("admin")) {
   		 	response.sendRedirect("admindetails.jsp?username="+username);
    		}
    		else {
       		response.sendRedirect("userdetails.jsp?username="+username);

    		}
    		
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        System.out.println(password);
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
      
        try {
            if (loginDao.validate(loginBean)) {
            	if(username.equals("admin")&&password.equals("admin")) {
            		request.setAttribute("username", username);

            		request.getSession().setAttribute("username", username); // add to session

            	    this.getServletConfig().getServletContext().setAttribute("username", username);
            		RequestDispatcher dispatcher = request.getRequestDispatcher("admindetails.jsp");
                    dispatcher.forward(request, response);
            		
                    


            	} else {
            		request.setAttribute("username", username);
            		request.getSession().setAttribute("username", username);
            		request.getSession().setAttribute("password", password);
            	    this.getServletConfig().getServletContext().setAttribute("password", password);

            	    this.getServletConfig().getServletContext().setAttribute("username", username);
            	
            		RequestDispatcher dispatcher = request.getRequestDispatcher("userdetails.jsp");
                    dispatcher.forward(request, response);
                     }
            	
               
                
            } else {
            	String message = "Invalid email/password";
                request.setAttribute("message", message);
                response.sendRedirect("home.jsp");

               
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}