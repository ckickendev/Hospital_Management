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
 * Servlet implementation class PatientServlet
 */
@WebServlet("/patient")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientController() {
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
		request.setAttribute("patient", new PatientDAO().getPatients());
		request.getRequestDispatcher("Admin/UI/Patient/patients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		new PatientDAO().addPatient(new Patient(0, request.getParameter("name"), request.getParameter("dob"), request.getParameter("gender"), request.getParameter("address"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("idcard")));
		doGet(request, response);
	}

}
