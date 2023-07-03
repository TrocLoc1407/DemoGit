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
 * Servlet implementation class HoaDonControl
 */
@WebServlet("/hoaDon")
public class HoaDonControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HoaDonControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO dao = new DAO();
      
        

        double sumAllInvoice = ServletRepository.getInstance().sumAllInvoice();
        
        var listAllInvoice = ServletRepository.getInstance().getAllInvoice();
        var listAllAccount = ServletRepository.getInstance().getAllAccount();
        //List<Invoice> listAllInvoice = dao.getAllInvoice();
        //List<Account> listAllAccount = dao.getAllAccount();
        
        request.setAttribute("listAllInvoice", listAllInvoice);
        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("sumAllInvoice", sumAllInvoice);
        
      
        request.getRequestDispatcher("HoaDon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
