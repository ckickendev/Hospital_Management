package web.java.AdminController.blood;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.BloodBankDAO;
import web.java.dao.MedicaltionDAO;
import web.java.model.BloodBank;
import web.java.model.Medication;

/**
 * Servlet implementation class BloodEdit
 */
@WebServlet("/blood/edit")
public class BloodEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodEdit() {
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
		request.setAttribute("blood", new BloodBankDAO().findBloodBank(request.getParameter("id")));
		request.getRequestDispatcher("../Admin/UI/BloodBank/bloodbankEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		BloodBankDAO bloodBankDAO = new BloodBankDAO();
		BloodBank bloodBank = new BloodBank(Integer.parseInt(request.getParameter("id")), request.getParameter("bbname"), request.getParameter("address"),
				request.getParameter("phone"), request.getParameter("remain"));
		bloodBankDAO.updateBloodBank(bloodBank);
		response.sendRedirect("http://localhost:8080/Hospital_Management/bloodbank");
	}

}
