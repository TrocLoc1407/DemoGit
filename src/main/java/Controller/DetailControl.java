package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.*;
import Dao.*;
import Interface.*;
import Repository.*;
/**
 * Servlet implementation class DetailControl
 */
@WebServlet("/detail")
public class DetailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		var p = ServletRepository.getInstance().getProductByID(id);
        //DAO dao = new DAO();
        //Product p = dao.getProductByID(id);
        
        int cateIDProductDetail = ServletRepository.getInstance().getCateIDByProductID(id);
        //List<Product> listRelatedProduct = dao.getRelatedProduct(cateIDProductDetail);
        var listRelatedProduct = ServletRepository.getInstance().getRelatedProduct(cateIDProductDetail);
        //List<Review> listAllReview = dao.getAllReviewByProductID(id);
        var listAllReview = ServletRepository.getInstance().getAllReviewByProductID(id);
        int countAllReview = listAllReview.size();
        
        
        var listAllAcount = ServletRepository.getInstance().getAllAccount();
        //List<Account> listAllAcount = dao.getAllAccount();
        
        var last = ServletRepository.getInstance().getLast();
        //Product last = dao.getLast();

        request.setAttribute("detail", p);
        request.setAttribute("listRelatedProduct", listRelatedProduct);
        request.setAttribute("listAllReview", listAllReview);
        request.setAttribute("listAllAcount", listAllAcount);
        request.setAttribute("countAllReview", countAllReview);
        request.setAttribute("p", last);
        request.getRequestDispatcher("DetailProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
