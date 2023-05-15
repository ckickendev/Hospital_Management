package web.java.controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.java.dao.EmployeeDAO;
import web.java.model.Employee;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.setAttribute("users", new EmployeeDAO().getAllUser());
		request.getRequestDispatcher("Admin/common/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String encodePass = new EmployeeDAO().getEncodedString(password);
		if (username.isEmpty() == true || password.isEmpty() == true) {
			request.setAttribute("mess", "Username and password must not empty");
			request.getRequestDispatcher("Admin/common/login.jsp").forward(request, response);
		} else {
			if (new EmployeeDAO().login(username, encodePass) == true) {
				Cookie userId = new Cookie("loginId",
						Integer.toString(new EmployeeDAO().getUserByUsername(username).getId()));
				Cookie userName = new Cookie("loginName", new EmployeeDAO().getUserByUsername(username).getUsername());
				userId.setMaxAge(60 * 60 * 24);
				userName.setMaxAge(60 * 60 * 24);
				response.addCookie(userId);
				response.addCookie(userName);

				HttpSession session = request.getSession();
				session.setAttribute("loginSession",
						new EmployeeDAO().getUserById(Integer.toString(new EmployeeDAO().getUserByUsername(username).getId())));
				System.out.println(((Employee) session.getAttribute("loginSession")).getName());
				response.sendRedirect("home");
			} else {
				request.setAttribute("mess", "Wrong username and password, please check again");
				request.getRequestDispatcher("Admin/common/login.jsp").forward(request, response);
			}
		}
	}

}
