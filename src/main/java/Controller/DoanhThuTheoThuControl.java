package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.*;
import Dao.*;
import Repository.*;
import Interface.*;
/**
 * Servlet implementation class DoanhThuTheoThuControl
 */
@WebServlet("/doanhThuTheoThu")
public class DoanhThuTheoThuControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoanhThuTheoThuControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO dao = new DAO();
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
        
        
        
        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);
        
    
        
        request.getRequestDispatcher("DoanhThuTheoThu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
