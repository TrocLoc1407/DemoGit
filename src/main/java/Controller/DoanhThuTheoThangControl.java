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
 * Servlet implementation class DoanhThuTheoThangControl
 */
@WebServlet("/doanhThuTheoThang")
public class DoanhThuTheoThangControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoanhThuTheoThangControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO dao = new DAO();
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
        
       
    
        request.getRequestDispatcher("DoanhThuTheoThang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
