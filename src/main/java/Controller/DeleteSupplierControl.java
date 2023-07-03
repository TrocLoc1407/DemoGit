package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Dao.*;
import Models.*;
import Repository.*;
import Interface.*;
/**
 * Servlet implementation class DeleteSupplierControl
 */
@WebServlet("/deleteSupplier")
public class DeleteSupplierControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSupplierControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idSupplier = request.getParameter("id");
		ServletRepository.getInstance().deleteSupplier(idSupplier);
        //DAO dao = new DAO();
        //dao.deleteSupplier(idSupplier);
        request.setAttribute("mess", "Supplier Deleted!");
        request.getRequestDispatcher("managerSupplier").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
