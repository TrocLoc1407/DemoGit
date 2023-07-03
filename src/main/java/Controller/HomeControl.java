package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Dao.*;
import Models.*;
import Repository.*;
import Interface.*;


/**
 * Servlet implementation class HomeControl
 */
@WebServlet("/home")
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		var listC = ServletRepository.getInstance().getAllCategory();
		var list = ServletRepository.getInstance().getTop3();
		var list8Last = ServletRepository.getInstance().get8Last();
		var list4NikeLast = ServletRepository.getInstance().get4NikeLast();
		var list4AdidasLast = ServletRepository.getInstance().get4AdidasLast();
		var last = ServletRepository.getInstance().getLast();
//      List<Product> list = dao.getAllProduct();
      
     
      
      
      
     
      request.setAttribute("listP", list);
      request.setAttribute("listCC", listC);
      request.setAttribute("list8Last", list8Last);
      request.setAttribute("list4NikeLast", list4NikeLast);
      request.setAttribute("list4AdidasLast", list4AdidasLast);
      request.setAttribute("p", last);
      request.getRequestDispatcher("Home.jsp").forward(request, response);
      //404 -> url
      //500 -> jsp properties
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
