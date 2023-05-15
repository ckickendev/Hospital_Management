package web.java.AdminController.DispensedMedication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.ls.LSOutput;

import web.java.dao.DispensedMedicationDAO;
import web.java.dao.HospitalFeeDAO;
import web.java.dao.MedicaltionDAO;
import web.java.model.DispenseMedication;
import web.java.model.HospitalFee;

/**
 * Servlet implementation class DispenseController
 */
@WebServlet("/dispense/edit")
public class DispenseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispenseController() {
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
		request.setAttribute("dispenses", new DispensedMedicationDAO().findDispense(request.getParameter("id")));
		request.setAttribute("medications", new MedicaltionDAO().getAllMedication());
		request.getRequestDispatcher("../Admin/UI/Medication/dispenseEdit.jsp").forward(request, response);
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
		System.out.println(request.getParameter("medication"));
		new DispensedMedicationDAO().addDispensedMedication(
				new DispenseMedication(0, Integer.parseInt(request.getParameter("medication")),
						request.getParameter("date"), Integer.parseInt(request.getParameter("qtt")),
						request.getParameter("notes"), request.getParameter("dispenseId")));
		response.sendRedirect("http://localhost:8080/Hospital_Management/dispense/edit?id=" +request.getParameter("dispenseId") );
	}

}
