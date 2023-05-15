package web.java.AdminController.Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.BloodBankDAO;
import web.java.dao.ExaminationDAO;
import web.java.dao.TestResultDAO;
import web.java.model.Examination;
import web.java.model.TestResult;

/**
 * Servlet implementation class TestController
 */
@WebServlet(name = "tests", urlPatterns = { "/tests" })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestController() {
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
		request.setAttribute("tests", new TestResultDAO().getTestResults());
		request.getRequestDispatcher("Admin/UI/Test/tests.jsp").forward(request, response);
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
		new TestResultDAO().addTestResult(new TestResult(0, Integer.parseInt(request.getParameter("patient_id")),
				Integer.parseInt(request.getParameter("service_id")), request.getParameter("date"),
				request.getParameter("note"), request.getParameter("result")));
		doGet(request, response);
	}

}
