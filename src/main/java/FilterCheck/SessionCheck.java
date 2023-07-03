package FilterCheck;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

public class SessionCheck implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
		 
        // "login" la servlet  
        if(session == null && !(uri.endsWith("jsp") || uri.endsWith("login"))){	
        	res.sendRedirect("Login.jsp");
        }else {
        	//pass the request along the filter
        	chain.doFilter(request, response);
        }
        
		
	}

}
