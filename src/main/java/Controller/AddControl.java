package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import Models.*;
import Interface.*;
import Repository.*;
import Dao.*;
/**
 * Servlet implementation class AddControl
 */
@WebServlet("/add")
public class AddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        
        String pimage2 = request.getParameter("image2");
        String pimage3 = request.getParameter("image3");
        String pimage4 = request.getParameter("image4");
        String pmodel = request.getParameter("model");
        String pcolor = request.getParameter("color");
        String pdelivery = request.getParameter("delivery");
        
        String pprice = request.getParameter("price");
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pcategory = request.getParameter("category");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getId();
        
        ServletRepository.getInstance().insertProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, sid, pmodel, pcolor, pdelivery, pimage2, pimage3, pimage4);
        //DAO dao = new DAO();
        //dao.insertProduct(pname, pimage, pprice, ptitle, pdescription, pcategory, sid, pmodel, pcolor, pdelivery, pimage2, pimage3, pimage4);
        request.setAttribute("mess", "Product Added!");
        request.getRequestDispatcher("manager").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
