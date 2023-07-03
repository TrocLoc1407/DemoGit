package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import FilterCheck.SessionCheck;
import Models.*;
import Repository.*;
/**
 * Servlet implementation class ShopControl
 */
@WebServlet("/shop")

public class ShopControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SessionCheck sc = new SessionCheck();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopControl() {
        super();
//        sc.doFilter(null, null, null)
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO dao = new DAO();
		
		
		//List<Product> list = dao.getAllProduct();
		//List<Category> listC = dao.getAllCategory();
		var listC = ServletRepository.getInstance().getAllCategory();
     
      
      String index = request.getParameter("index");
      if(index == null) {
      	index="1";
      }
      int indexPage = Integer.parseInt(index);
      
      var list = ServletRepository.getInstance().getProductByIndex(indexPage);
      //List<Product> list = dao.getProductByIndex(indexPage);
//      List<Category> listC = dao.getAllCategory();
      int allProduct = ServletRepository.getInstance().countAllProduct();
      int endPage = allProduct/9;
      if(allProduct % 9 != 0) {
      	endPage++;
      }
      
      
      request.setAttribute("tag", indexPage);
      request.setAttribute("endPage", endPage);
      request.setAttribute("listCC", listC);
      request.setAttribute("listP", list);
      
      
      
      


      request.getRequestDispatcher("Shop.jsp").forward(request, response);
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
