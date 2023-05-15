package web.java.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.EmployeeDAO;
import web.java.model.Employee;

/**
 * Servlet Filter implementation class CheckCookie
 */
@WebFilter({ "/home", "/patient", "/inpatient", "/tests", "/feeTotal", "/examination", "/dismedication", "/bloodbank",
		"/medication", "/service", "/employee" })
public class FilterAuthor implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterAuthor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		Cookie[] cookies = request2.getCookies();
		boolean login = false;
		if (cookies != null) {
			for (Cookie ck : cookies) {
				if (ck.getName().equals("loginId")) {
					login = true;
					Employee user = new EmployeeDAO().getUserById(ck.getValue());
					request2.setAttribute("userLogin", user);
					request2.setAttribute("userLoginId", ck.getValue());
				}
			}
		} else {
			httpResponse.sendRedirect("authorize");
		}

		if (login == false) {
			httpResponse.sendRedirect("authorize");
			return;
		} else {
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
