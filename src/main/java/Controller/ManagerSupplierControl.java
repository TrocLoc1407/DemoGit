package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Repository.ServletRepository;

/**
 * Servlet implementation class ManagerSupplierControl
 */
@WebServlet("/managerSupplier")

public class ManagerSupplierControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerSupplierControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //DAO dao = new DAO();

	       // List<Supplier> listAllSupplier = dao.getAllSupplier();
	       // List<Category> listAllCategory = dao.getAllCategory();
		var listAllSupplier = ServletRepository.getInstance().getAllSupplier();
		var listAllCategory = ServletRepository.getInstance().getAllCategory();

	        request.setAttribute("listAllSupplier", listAllSupplier);
	        request.setAttribute("listAllCategory", listAllCategory);

	        request.getRequestDispatcher("NhaPhanPhoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
