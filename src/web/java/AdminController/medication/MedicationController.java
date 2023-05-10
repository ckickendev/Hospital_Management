package web.java.AdminController.medication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.MedicaltionDAO;
import web.java.model.Medication;

/**
 * Servlet implementation class MedicationController
 */
@WebServlet("/medication")
public class MedicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicationController() {
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
		request.setAttribute("medications", new MedicaltionDAO().getAllMedication());
		request.getRequestDispatcher("Admin/UI/Medication/medication.jsp").forward(request, response);
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
		MedicaltionDAO medicaltionDAO = new MedicaltionDAO();

		Medication medication = new Medication(0, request.getParameter("name"), request.getParameter("dosage"),
				request.getParameter("notes"), Float.parseFloat(request.getParameter("price")));
		medicaltionDAO.addMedication(medication);

		request.setAttribute("medications", new MedicaltionDAO().getAllMedication());
		request.getRequestDispatcher("Admin/UI/medication.jsp").forward(request, response);
	}

}
