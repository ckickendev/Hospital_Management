package web.java.AdminController.Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.HospitalFeeDAO;
import web.java.dao.PatientDAO;
import web.java.dao.TestResultDAO;
import web.java.model.TestResult;

/**
 * Servlet implementation class TestEdit
 */
@WebServlet(name = "test/edit", urlPatterns = { "/test/edit" })
public class TestEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.setAttribute("test", new TestResultDAO().findTestResult(request.getParameter("id")));
		request.setAttribute("patients", new PatientDAO().getPatients());
		request.setAttribute("services", new HospitalFeeDAO().getHospitalFees());
		request.getRequestDispatcher("../Admin/UI/Test/testEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		new TestResultDAO().updateTestResult(new TestResult(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("patient_id")),
				Integer.parseInt(request.getParameter("service_id")), request.getParameter("date"),
				request.getParameter("note"), request.getParameter("result")));
		response.sendRedirect("http://localhost:8080/Hospital_Management/tests");
	}

}
