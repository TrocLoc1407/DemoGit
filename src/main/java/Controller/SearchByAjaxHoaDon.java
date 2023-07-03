package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Repository.*;
import Models.*;
/**
 * Servlet implementation class SearchByAjaxHoaDon
 */
@WebServlet("/searchAjaxHoaDon")
public class SearchByAjaxHoaDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByAjaxHoaDon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ngayXuat = request.getParameter("ngayXuat");
        //DAO dao = new DAO();
		var listInvoiceByDate = ServletRepository.getInstance().searchByNgayXuat(ngayXuat);
		var listAllAccount = ServletRepository.getInstance().getAllAccount();
        //List<Invoice> listInvoiceByDate = dao.searchByNgayXuat(ngayXuat);
        //List<Account> listAllAccount = dao.getAllAccount();
        PrintWriter out = response.getWriter(); 
        double tongGia;
        for (Invoice o : listInvoiceByDate) {
        	for (Account a : listAllAccount) {
        		if(o.getAccountID() == a.getId()) {	
        			tongGia=Math.round((o.getTongGia()) * 100.0) / 100.0;
        	out.println("<tr>\r\n"
        			+ "                  <th scope=\"row\"></th>\r\n"
        			+ "                  <td>"+o.getMaHD()+"</td>\r\n"
        			+ "                  <td>"+a.getUser()+"</td>\r\n"
        			+ "                  <td>"+tongGia+"</td>\r\n"
        			+ "                  <td>"+o.getNgayXuat()+"</td> \r\n"
        			+ "                </tr>");
        		}
        		}
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
