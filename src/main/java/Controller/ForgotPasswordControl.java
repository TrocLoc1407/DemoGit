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
 * Servlet implementation class ForgotPasswordControl
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			
			//DAO dao = new DAO();
			Account account = ServletRepository.getInstance().checkAccountExistByUsernameAndEmail(username, emailAddress);
			if(account == null) {
				request.setAttribute("error", "Email hoac username sai!");
			}
			if(account != null) {
				Email email =new Email();
				email.setFrom("dinhkha14072003@gmail.com");
				email.setFromPassword("dreqnintbzrsmzte");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Function");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				sb.append("You are used the forgot password. <br> ");
				sb.append("Your password is <b>").append(account.getPass()).append(" </b> <br>");
				sb.append("Regards<br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				request.setAttribute("mess", "Mat khau da duoc gui den email cua ban!");
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
