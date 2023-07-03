package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Models.*;
import Repository.*;
/**
 * Servlet implementation class SignUpControl
 */
@WebServlet("/signup")
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String email = request.getParameter("email");
        if(!pass.equals(re_pass)){
            response.sendRedirect("Login.jsp");
        }else{
            //DAO dao = new DAO();
            Account a = ServletRepository.getInstance().checkAccountExist(user);
            if(a == null){
                //dc signup
                ServletRepository.getInstance().singup(user, pass, email);
                response.sendRedirect("login");
            }else{
                //day ve trang login.jsp
                response.sendRedirect("Login.jsp");
            }
        }
	}

}
