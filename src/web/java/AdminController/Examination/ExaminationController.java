package web.java.AdminController.Examination;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.ExaminationDAO;
import web.java.dao.HospitalFeeDAO;
import web.java.model.Examination;

/**
 * Servlet implementation class ExaminationController
 */
@WebServlet("/examination")
public class ExaminationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExaminationController() {
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
		request.setAttribute("examinations", new ExaminationDAO().getExaminations());
		request.getRequestDispatcher("Admin/UI/MedicalExamination/examinations.jsp").forward(request, response);
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
		System.out.println("vo day");
		new ExaminationDAO().addExam(new Examination(0, Integer.parseInt(request.getParameter("patient_id")),
				Integer.parseInt(request.getParameter("doctor_id")), request.getParameter("date"),
				request.getParameter("sym"), request.getParameter("dia"), request.getParameter("note")));
		doGet(request, response);
	}

}
