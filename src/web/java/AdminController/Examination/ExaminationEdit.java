package web.java.AdminController.Examination;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.EmployeeDAO;
import web.java.dao.ExaminationDAO;
import web.java.dao.PatientDAO;
import web.java.model.Examination;

/**
 * Servlet implementation class ExaminationEdit
 */
@WebServlet("/examination/edit")
public class ExaminationEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExaminationEdit() {
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
		request.setAttribute("examination", new ExaminationDAO().findExamination(request.getParameter("id")));
		request.setAttribute("patients", new PatientDAO().getPatients());
		request.setAttribute("doctors", new EmployeeDAO().getAllDoctor());
		request.getRequestDispatcher("../Admin/UI/MedicalExamination/examinationEdit.jsp").forward(request, response);
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
		new ExaminationDAO().updateExam(new Examination(Integer.parseInt(request.getParameter("id")),
				Integer.parseInt(request.getParameter("patient_id")),
				Integer.parseInt(request.getParameter("doctor_id")), request.getParameter("date"),
				request.getParameter("sym"), request.getParameter("dia"), request.getParameter("note")));
		response.sendRedirect("http://localhost:8080/Hospital_Management/examination");
	}

}
