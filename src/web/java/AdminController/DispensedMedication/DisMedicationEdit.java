package web.java.AdminController.DispensedMedication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.DispensedMedicationDAO;
import web.java.dao.HospitalFeeDAO;
import web.java.model.DispenseMedication;
import web.java.model.HospitalFee;

/**
 * Servlet implementation class DisMedicationEdit
 */
@WebServlet("/disMedication/edit")
public class DisMedicationEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisMedicationEdit() {
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
		request.setAttribute("dismedication", new DispensedMedicationDAO().findDispensedMedication(request.getParameter("id")));
		request.getRequestDispatcher("../Admin/UI/Medication/disMedicationEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
//		new DispensedMedicationDAO().updateDisMedication(new DispenseMedication(0, Integer.parseInt(request.getParameter("patient_id")),
//						Integer.parseInt(request.getParameter("medical_id")), request.getParameter("dispense"),
//						Integer.parseInt(request.getParameter("qtt")), request.getParameter("notes")));
		response.sendRedirect("http://localhost:8080/Hospital_Management/service");
	}

}
