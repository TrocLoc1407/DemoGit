package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Models.*;
import Dao.*;
import Repository.*;
import Interface.*;
/**
 * Servlet implementation class LoadAmountCartControl
 */
@WebServlet("/loadAllAmountCart")
public class LoadAmountCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAmountCartControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalAmountCart =0;
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if(a == null) {
        	PrintWriter out = response.getWriter();
            out.println(totalAmountCart);
        	return;
        }
        int accountID = a.getId();
        var list = ServletRepository.getInstance().getCartByAccountID(accountID);
        //DAO dao = new DAO();
        //List<Cart> list = dao.getCartByAccountID(accountID);
        totalAmountCart = list.size();
        
        
        //in list p day
        PrintWriter out = response.getWriter();
        out.println(totalAmountCart);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
