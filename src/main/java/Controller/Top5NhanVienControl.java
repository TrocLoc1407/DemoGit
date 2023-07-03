package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Repository.ServletRepository;

/**
 * Servlet implementation class Top5NhanVienControl
 */
@WebServlet("/top5nhanvien")
public class Top5NhanVienControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top5NhanVienControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO dao = new DAO();

        //List<Account> listAllAccount = dao.getAllAccount();
        //List<TongChiTieuBanHang> listTop5NhanVien = dao.getTop5NhanVien();
		var listAllAccount = ServletRepository.getInstance().getAllAccount();
		var listTop5NhanVien = ServletRepository.getInstance().getTop5NhanVien();

        request.setAttribute("listAllAccount", listAllAccount);
        request.setAttribute("listTop5NhanVien", listTop5NhanVien);

        request.getRequestDispatcher("Top5NhanVien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
