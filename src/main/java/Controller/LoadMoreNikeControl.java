package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Repository.ServletRepository;
import Dao.*;
import Models.*;
import Interface.*;

/**
 * Servlet implementation class LoadMoreNikeControl
 */
@WebServlet("/loadNike")
public class LoadMoreNikeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadMoreNikeControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amount = request.getParameter("exitsNike");
        int iamount = Integer.parseInt(amount);
        //DAO dao = new DAO();
        //List<Product> list = dao.getNext4NikeProduct(iamount);
        var list = ServletRepository.getInstance().getNext4NikeProduct(iamount);
        PrintWriter out = response.getWriter();

        for (Product o : list) {
            out.println("<div class=\"productNike col-12 col-md-6 col-lg-3\">\r\n"
            		+ "                                <div class=\"card\">\r\n"
            		+ "                                 <div class=\"view zoom z-depth-2 rounded\">\r\n"
            		+ "                                    <img class=\"img-fluid w-100\" src=\""+o.getImage()+"\" alt=\"Card image cap\">\r\n"
            		+ "                                    </div>\r\n"
            		+ "                                    <div class=\"card-body\">\r\n"
            		+ "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid="+o.getId()+"\" title=\"View Product\">"+o.getName()+"</a></h4>\r\n"
            		+ "                                        <p class=\"card-text show_txt\">"+o.getTitle()+"</p>\r\n"
            		+ "                                        <div class=\"row\">\r\n"
            		+ "                                            <div class=\"col\">\r\n"
            		+ "                                                <p class=\"btn btn-success btn-block\">"+o.getPrice()+" $</p>\r\n"
            		+ "                                            </div>\r\n"
            		+ "                                            \r\n"
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
