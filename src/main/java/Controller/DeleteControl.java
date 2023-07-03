package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.*;
import Dao.*;
import Interface.*;
import Repository.*;
/**
 * Servlet implementation class DeleteControl
 */
@WebServlet("/delete")
public class DeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String pid = request.getParameter("pid");
		 ServletRepository.getInstance().deleteCartByProductID(pid);
		 ServletRepository.getInstance().deleteReviewByProductID(pid);
		 ServletRepository.getInstance().deleteProduct(pid);
	        //DAO dao = new DAO();
	        //dao.deleteCartByProductID(pid);
	        //dao.deleteReviewByProductID(pid);
	        //dao.deleteProduct(pid);
	        request.setAttribute("mess", "Deleted!");
	        request.getRequestDispatcher("manager").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
