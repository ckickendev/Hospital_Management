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
 * Servlet implementation class MedicationEdit
 */
@WebServlet("/medication/edit")
public class MedicationEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicationEdit() {
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
		request.setAttribute("medication", new MedicaltionDAO().findMedication(request.getParameter("id")));
		request.getRequestDispatcher("../Admin/UI/Medication/medicationEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		MedicaltionDAO medicaltionDAO = new MedicaltionDAO();
		Medication medication = new Medication(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("dosage"),
				request.getParameter("notes"), Float.parseFloat(request.getParameter("price")));
		medicaltionDAO.updateMedicationByID(medication);
		response.sendRedirect("http://localhost:8080/Hospital_Management/medication");
	}

}
