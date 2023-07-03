package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Repository.ServletRepository;

/**
 * Servlet implementation class AddAccountControl
 */
@WebServlet("/addAccount")
public class AddAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String isSell = request.getParameter("isSell");
        String isAdmin = request.getParameter("isAdmin");
        String email = request.getParameter("email");
       
        
        ServletRepository.getInstance().insertAccount(user, pass, isSell, isAdmin, email);
        
        request.setAttribute("mess", "Account Added!");

        request.getRequestDispatcher("managerAccount").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
