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
 * Servlet implementation class DeleteAccountControl
 */

@WebServlet("/deleteAccount")
public class DeleteAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        System.out.println("id: "+id);
        //DAO dao = new DAO();
        
        ServletRepository.getInstance().deleteCartByAccountID(Integer.parseInt(id));
        ServletRepository.getInstance().deleteProductBySellID(id);
        ServletRepository.getInstance().deleteReviewByAccountID(id);
        ServletRepository.getInstance().deleteInvoiceByAccountId(id);
        ServletRepository.getInstance().deleteTongChiTieuBanHangByUserID(id);
        ServletRepository.getInstance().deleteAccount(id);
        //dao.deleteCartByAccountID(Integer.parseInt(id));
        //dao.deleteProductBySellID(id);
        //dao.deleteReviewByAccountID(id);
        //dao.deleteInvoiceByAccountId(id);
        //dao.deleteTongChiTieuBanHangByUserID(id);
        //dao.deleteAccount(id);
        
        request.setAttribute("mess", "Account Deleted!");
        request.getRequestDispatcher("managerAccount").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
