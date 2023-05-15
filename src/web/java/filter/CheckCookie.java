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

import web.java.dao.EmployeeDAO;
import web.java.model.Employee;

/**
 * Servlet Filter implementation class CheckCookie
 */
@WebFilter({ "/patient/edit", "/inpatient/edit", "/tests/edit", "/feeTotal/edit", "/examination/edit",
		"/dismedication/edit", "/bloodbank/edit", "/medication/edit", "/service/edit", "/employee/edit" })
public class CheckCookie implements Filter {

	/**
	 * Default constructor.
	 */
	public CheckCookie() {
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
		String path = ((HttpServletRequest) request).getRequestURI();
		if (path.startsWith("/signout")) {
			chain.doFilter(request, response); // Just continue chain.
		}
		if (path.startsWith("/admin/")) {
			chain.doFilter(request, response); // Just continue chain.
		} else {
			HttpServletRequest request2 = (HttpServletRequest) request;
			Cookie[] cookies = request2.getCookies();

			if (cookies != null) {
				for (Cookie ck : cookies) {
					if (ck.getName().equals("loginId")) {
						Employee user = new EmployeeDAO().getUserById(ck.getValue());
						request2.setAttribute("userLogin", user);
						request2.setAttribute("userLoginId", ck.getValue());
					}
				}
			}
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
