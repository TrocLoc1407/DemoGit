package FilterCheck;

import java.io.IOException;

import org.apache.catalina.Authenticator;
import org.apache.catalina.connector.Request;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.lang.Object;


public class SessionExists implements Filter  {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
		
        if(session != null && !(uri.endsWith("jsp") || uri.endsWith("login"))) {
        	res.sendRedirect("Home.jsp");
        }else {
        	chain.doFilter(request, response);
        }
	}
	

	

}
