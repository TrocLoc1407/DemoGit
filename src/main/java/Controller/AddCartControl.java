package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import Models.*;
import Dao.*;
import Interface.*;
import Repository.*;

/**
 * Servlet implementation class AddCartControl
 */
@WebServlet("/addCart")
public class AddCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productID = Integer.parseInt(request.getParameter("pid"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int accountID = a.getId();
        int amount = Integer.parseInt(request.getParameter("quantity"));
        String size = request.getParameter("size");
        
        var cartExisted = ServletRepository.getInstance().checkCartExist(accountID, productID);
        //Cart cartExisted = dao.checkCartExist(accountID,productID);
        int amountExisted;
        String sizeExisted;
        if(cartExisted != null) {
        	 amountExisted = cartExisted.getAmount();
        	 ServletRepository.getInstance().editAmountAndSizeCart(accountID, productID, (amountExisted+amount), size);
        	 request.setAttribute("mess", "Da tang so luong san pham!");
        	 request.getRequestDispatcher("managerCart").forward(request, response);
        }
        else {
        	  ServletRepository.getInstance().insertCart(accountID, productID, amount, size);
        	  request.setAttribute("mess", "Da them san pham vao gio hang!");
        	  request.getRequestDispatcher("managerCart").forward(request, response);
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
