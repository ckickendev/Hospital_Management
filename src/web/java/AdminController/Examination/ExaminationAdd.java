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

/**
 * Servlet implementation class ExaminationAdd
 */
@WebServlet("/examinationAdd")
public class ExaminationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExaminationAdd() {
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
		request.getRequestDispatcher("Admin/UI/MedicalExamination/examinationAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
