package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import Models.*;
import Repository.*;
import Dao.*;
import Interface.*;
/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/login")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie arr[] = request.getCookies();
    	if(arr != null) {
    		for(Cookie o : arr) {
        		if(o.getName().equals("userC")) {
        			request.setAttribute("username", o.getValue());
        		}
        		if(o.getName().equals("passC")) {
        			request.setAttribute("password", o.getValue());
        		}
        	}
    	}
    	//b2: set user,pass to login form
        request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String remember =request.getParameter("remember");
        
        //DAO dao = new DAO();
        Account a = ServletRepository.getInstance().login(username, password);
        if (a == null) {
            request.setAttribute("error", "Sai username hoac password!");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            session.setMaxInactiveInterval(60*60*24);
          //luu account len tren cookie
            Cookie u = new Cookie("userC", username);
            Cookie p = new Cookie("passC", password);
            if(remember != null) {
           	 p.setMaxAge(60*60*24);
            }else {
           	 p.setMaxAge(0);
            }
            
            u.setMaxAge(60*60*24*365);//1 nam

            response.addCookie(u);//luu u va p len Browser
            response.addCookie(p);
            
            response.sendRedirect("home");
        }
	}

}
