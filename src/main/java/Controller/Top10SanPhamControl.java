package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Repository.ServletRepository;

/**
 * Servlet implementation class Top10SanPhamControl
 */
@WebServlet("/top10")
public class Top10SanPhamControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top10SanPhamControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO dao = new DAO();
		var listAllProduct = ServletRepository.getInstance().getAllProduct();
		var listTop10Product = ServletRepository.getInstance().getTop10SanPhamBanChay();
        //List<Product> listAllProduct = dao.getAllProduct();
        //List<SoLuongDaBan> listTop10Product = dao.getTop10SanPhamBanChay();


        
        
        request.setAttribute("listAllProduct", listAllProduct);
        request.setAttribute("listTop10Product", listTop10Product);

        request.getRequestDispatcher("Top10SanPhamBanChay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
