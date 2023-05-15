package web.java.AdminController.DispensedMedication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.DispensedMedicationDAO;
import web.java.dao.MedicaltionDAO;
import web.java.dao.PatientDAO;

/**
 * Servlet implementation class DisMedicationAdd
 */
@WebServlet("/dismedicationAdd")
public class DisMedicationAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisMedicationAdd() {
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
		request.setAttribute("dispenses", new DispensedMedicationDAO().getDispenses());
		request.setAttribute("medications", new MedicaltionDAO().getAllMedication());
		request.setAttribute("patients", new PatientDAO().getPatients());
		request.getRequestDispatcher("Admin/UI/Medication/dispenseMedicationAdd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
