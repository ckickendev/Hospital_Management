package web.java.AdminController.Patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.HospitalFeeDAO;
import web.java.dao.PatientDAO;
import web.java.model.HospitalFee;
import web.java.model.Patient;

/**
 * Servlet implementation class PatientEdit
 */
@WebServlet("/patient/edit")
public class PatientEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientEdit() {
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
		request.setAttribute("patient", new PatientDAO().findPatient(request.getParameter("id")));
		request.getRequestDispatcher("../Admin/UI/Patient/patientEdit.jsp").forward(request, response);
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
		System.out.println("request.getParameter(\"dob"+  request.getParameter("dob"));
		new PatientDAO()
				.updatePatient(new Patient(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
						request.getParameter("dob"), request.getParameter("gender"), request.getParameter("address"),
						request.getParameter("phone"), request.getParameter("email"), request.getParameter("idcard")));
		response.sendRedirect("http://localhost:8080/Hospital_Management/patient");
	}

}
