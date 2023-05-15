package web.java.AdminController.UserController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.EmployeeDAO;
import web.java.dao.PositionDAO;
import web.java.model.Employee;

/**
 * Servlet implementation class EditUserAdmin
 */
@WebServlet("/employee/editUser")
public class EditUserAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserAdmin() {
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

		String id = request.getParameter("id");
		EmployeeDAO userDAO = new EmployeeDAO();
		Employee userEdit = userDAO.getUserById(id);

		request.setAttribute("user", userEdit);
		request.setAttribute("pos", new PositionDAO().getAllPosition());
		request.getRequestDispatcher("../Admin/UI/Employee/EmployeeEdit.jsp").forward(request, response);
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
		System.out.println("request.getParameter(\"role\")" + request.getParameter("role"));
		int roleString = 1;
		System.out.println(request.getParameter("role"));
		if(request.getParameter("role") == null){
			roleString = 0;
		}
//		int roleString = request.getParameter("role").equals("on") ? 1 : 0;
		System.out.println("request.getParameter(\"id\")" + request.getParameter("id"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		String fullname = request.getParameter("name");
		System.out.println("rInteger.parseInt(request.getParameter(\"position\")" + request.getParameter("position"));
		Employee employee = new Employee(id, fullname, Integer.parseInt(request.getParameter("position")),
				request.getParameter("department"), request.getParameter("email"), request.getParameter("phone_number"),
				request.getParameter("username"), "", roleString);

		System.out.println("emp" + employee);

		EmployeeDAO userDAO = new EmployeeDAO();
		userDAO.updateUserById(employee);

//		String page = "";
//		if (request.getParameter("page") == null) {
//			page = "1";
//		} else {
//			page = request.getParameter("page");
//		}
//		List<Employee> users = userDAO.getAllUserInPage(Integer.parseInt(page));
//		int numberOfUsers = userDAO.countUser();
//		int numberOfPage = (int) Math.ceil(numberOfUsers / 10) + 1;
//
//		request.setAttribute("currentPage", Integer.parseInt(page));
//		request.setAttribute("users", users);
//		request.setAttribute("numberOfPage", numberOfPage);

//		request.getRequestDispatcher("../Admin/template/management/UserManagement.jsp").forward(request, response);
		response.sendRedirect("http://localhost:8080/Hospital_Management/employee");
	}

}
