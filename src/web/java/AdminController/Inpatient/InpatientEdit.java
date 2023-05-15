package web.java.AdminController.Inpatient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.HospitalFeeDAO;
import web.java.dao.InpatientDAO;
import web.java.dao.PatientDAO;
import web.java.model.HospitalFee;
import web.java.model.Inpatient;

/**
 * Servlet implementation class InpatientEdit
 */
@WebServlet("/inpatient/edit")
public class InpatientEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InpatientEdit() {
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
		Inpatient inpatient = new InpatientDAO().findInpatient(request.getParameter("id"));
		request.setAttribute("inpatient", inpatient );
		request.setAttribute("patientName", new PatientDAO().findPatient(Integer.toString(inpatient.getPatient_id())));
		request.setAttribute("patients", new PatientDAO().getPatients());
		request.getRequestDispatcher("../Admin/UI/Patient/inpatientEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("admission_date"));
		new InpatientDAO().updateInpatient(new Inpatient(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("patient_id")), request.getParameter("admission_date"),request.getParameter("discharge_date"),request.getParameter("room"), request.getParameter("notes")));
		response.sendRedirect("http://localhost:8080/Hospital_Management/inpatient");
	}

}
