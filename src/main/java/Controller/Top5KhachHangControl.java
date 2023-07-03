package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Repository.ServletRepository;

/**
 * Servlet implementation class Top5KhachHangControl
 */
@WebServlet("/top5khachhang")
public class Top5KhachHangControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top5KhachHangControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO dao = new DAO();
		
		var listAllAccount = ServletRepository.getInstance().getAllAccount();
		var listTop5KhachHang = ServletRepository.getInstance().getTop5KhachHang();
        //List<Account> listAllAccount = dao.getAllAccount();
        //List<TongChiTieuBanHang> listTop5KhachHang = dao.getTop5KhachHang();


        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("listTop5KhachHang", listTop5KhachHang);
//        request.getRequestDispatcher("ManagerAccount.jsp").forward(request, response);
        request.getRequestDispatcher("Top5KhachHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
