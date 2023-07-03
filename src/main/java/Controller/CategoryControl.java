package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Models.*;
import Dao.*;
import Interface.*;
import Repository.*;
/**
 * Servlet implementation class CategoryControl
 */
@WebServlet("/category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cateID = request.getParameter("cid");
        //da lay dc category id ve roi
		
		 var list = ServletRepository.getInstance().getProductByCID(cateID);
		
		
        //DAO dao = new DAO();
        //List<Product> list = dao.getProductByCID(cateID);
        //in list p day
        PrintWriter out = response.getWriter();
        for(Product o : list) {
        	out.println(" <div class=\"product col-12 col-md-6 col-lg-4\">\r\n"
        			+ "                                <div class=\"card\">\r\n"
        			+ "                                    <img class=\"card-img-top\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\r\n"
        			+ "                                    <div class=\"card-body\">\r\n"
        			+ "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getId()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\r\n"
        			+ "                                        <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\r\n"
        			+ "                                        <div class=\"row\">\r\n"
        			+ "                                            <div class=\"col\">\r\n"
        			+ "                                                <p class=\"btn btn-danger btn-block\">"+o.getPrice()+" $</p>\r\n"
        			+ "                                            </div>\r\n"
        			+ "                                            <div class=\"col\">\r\n"
        			+ "                                                <a href=\"#\" class=\"btn btn-success btn-block\">Add to cart</a>\r\n"
        			+ "                                            </div>\r\n"
        			+ "                                        </div>\r\n"
        			+ "                                    </div>\r\n"
        			+ "                                </div>\r\n"
        			+ "                            </div>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
