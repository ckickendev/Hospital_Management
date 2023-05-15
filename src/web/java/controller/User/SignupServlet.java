package web.java.controller.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.EmployeeDAO;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		request.getRequestDispatcher("Admin/common/signup.jsp").forward(request, response);
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
		if (request.getParameter("username").isEmpty() == true || request.getParameter("password").isEmpty() == true
				|| request.getParameter("email").isEmpty() == true
				|| request.getParameter("fullname").isEmpty() == true) {
			request.setAttribute("mess", "Please fill all field");
			request.getRequestDispatcher("Admin/common/signup.jsp").forward(request, response);
			return;
		} else {
			if (new EmployeeDAO().getUserByUsername(request.getParameter("username")).getId() != 0) {
				request.setAttribute("mess", "Username exist");
				request.getRequestDispatcher("Page/web/signup.jsp").forward(request, response);
				return;
			}
			new EmployeeDAO().signUp(request.getParameter("username"), request.getParameter("password"),
					request.getParameter("email"), request.getParameter("fullname"));
			request.setAttribute("mess", "Sign up successfull");
			request.getRequestDispatcher("Admin/common/signup.jsp").forward(request, response);
		}

	}

}
