package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import Dao.*;
import Models.*;
import Repository.*;
/**
 * Servlet implementation class StatisticControl
 */
@WebServlet("/admin")
public class StatisticControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int uID;
        //DAO dao = new DAO();
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        uID= a.getId();
 	   int checkIsAdmin = ServletRepository.getInstance().checkAccountAdmin(uID);
       if(checkIsAdmin == 0)
       {
       		response.sendRedirect("login");
       		return;
       }
        	
        	
       double totalMoney1 = ServletRepository.getInstance().totalMoneyDay(1);
       double totalMoney2 = ServletRepository.getInstance().totalMoneyDay(2);
       double totalMoney3 = ServletRepository.getInstance().totalMoneyDay(3);
       double totalMoney4 = ServletRepository.getInstance().totalMoneyDay(4);
       double totalMoney5 = ServletRepository.getInstance().totalMoneyDay(5);
       double totalMoney6 = ServletRepository.getInstance().totalMoneyDay(6);
       double totalMoney7 = ServletRepository.getInstance().totalMoneyDay(7);
       
        //double totalMoney1 = dao.totalMoneyDay(1);
        //double totalMoney2 = dao.totalMoneyDay(2);
        //double totalMoney3 = dao.totalMoneyDay(3);
        //double totalMoney4 = dao.totalMoneyDay(4);
        //double totalMoney5 = dao.totalMoneyDay(5);
        //double totalMoney6 = dao.totalMoneyDay(6);
        //double totalMoney7 = dao.totalMoneyDay(7);
        
       
       
       double totalMoneyMonth1 = ServletRepository.getInstance().totalMoneyMonth(1);
       double totalMoneyMonth2 = ServletRepository.getInstance().totalMoneyMonth(2);
       double totalMoneyMonth3 = ServletRepository.getInstance().totalMoneyMonth(3);
       double totalMoneyMonth4 = ServletRepository.getInstance().totalMoneyMonth(4);
       double totalMoneyMonth5 = ServletRepository.getInstance().totalMoneyMonth(5);
       double totalMoneyMonth6 = ServletRepository.getInstance().totalMoneyMonth(6);
       double totalMoneyMonth7 = ServletRepository.getInstance().totalMoneyMonth(7);
       double totalMoneyMonth8 = ServletRepository.getInstance().totalMoneyMonth(8);
       double totalMoneyMonth9 = ServletRepository.getInstance().totalMoneyMonth(9);
       double totalMoneyMonth10 = ServletRepository.getInstance().totalMoneyMonth(10);
       double totalMoneyMonth11 = ServletRepository.getInstance().totalMoneyMonth(11);
       double totalMoneyMonth12 = ServletRepository.getInstance().totalMoneyMonth(12);
       
        //double totalMoneyMonth1 = dao.totalMoneyMonth(1);
        //double totalMoneyMonth2 = dao.totalMoneyMonth(2);
        //double totalMoneyMonth3 = dao.totalMoneyMonth(3);
        //double totalMoneyMonth4 = dao.totalMoneyMonth(4);
        //double totalMoneyMonth5 = dao.totalMoneyMonth(5);
        //double totalMoneyMonth6 = dao.totalMoneyMonth(6);
        //double totalMoneyMonth7 = dao.totalMoneyMonth(7);
        //double totalMoneyMonth8 = dao.totalMoneyMonth(8);
        //double totalMoneyMonth9 = dao.totalMoneyMonth(9);
        //double totalMoneyMonth10 = dao.totalMoneyMonth(10);
        //double totalMoneyMonth11 = dao.totalMoneyMonth(11);
        //double totalMoneyMonth12 = dao.totalMoneyMonth(12);
        
        int allReview = ServletRepository.getInstance().countAllReview();
        int allProduct = ServletRepository.getInstance().countAllProduct();
        double sumAllInvoice = ServletRepository.getInstance().sumAllInvoice();
        
        
        var listAllInvoice = ServletRepository.getInstance().getAllInvoice(); 
        var listAllAccount = ServletRepository.getInstance().getAllAccount();
        //List<Invoice> listAllInvoice = dao.getAllInvoice();
        //List<Account> listAllAccount = dao.getAllAccount();
        
        request.setAttribute("listAllInvoice", listAllInvoice);
        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("sumAllInvoice", sumAllInvoice);
        
        request.setAttribute("allReview", allReview);
        request.setAttribute("allProduct", allProduct);
        
        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);
        
        request.setAttribute("totalMoneyMonth1", totalMoneyMonth1);
        request.setAttribute("totalMoneyMonth2", totalMoneyMonth2);
        request.setAttribute("totalMoneyMonth3", totalMoneyMonth3);
        request.setAttribute("totalMoneyMonth4", totalMoneyMonth4);
        request.setAttribute("totalMoneyMonth5", totalMoneyMonth5);
        request.setAttribute("totalMoneyMonth6", totalMoneyMonth6);
        request.setAttribute("totalMoneyMonth7", totalMoneyMonth7);
        request.setAttribute("totalMoneyMonth8", totalMoneyMonth8);
        request.setAttribute("totalMoneyMonth9", totalMoneyMonth9);
        request.setAttribute("totalMoneyMonth10", totalMoneyMonth10);
        request.setAttribute("totalMoneyMonth11", totalMoneyMonth11);
        request.setAttribute("totalMoneyMonth12", totalMoneyMonth12);
        
       
    
        request.getRequestDispatcher("Statistic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
