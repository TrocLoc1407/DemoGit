package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.*;
import Repository.*;
import Dao.*;
import Interface.*;
/**
 * Servlet implementation class LoadControl
 */
@WebServlet("/loadProduct")
public class LoadControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
        //DAO dao = new DAO();
        Product p = ServletRepository.getInstance().getProductByID(id);
        //List<Category> listC = dao.getAllCategory();
        
        var listC = ServletRepository.getInstance().getAllCategory();
        
        request.setAttribute("detail", p);
        request.setAttribute("listCC", listC);
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
