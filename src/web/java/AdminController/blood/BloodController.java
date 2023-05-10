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
 * Servlet implementation class BloodController
 */
@WebServlet("/bloodbank")
public class BloodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BloodController() {
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
		request.setAttribute("bloods", new BloodBankDAO().getBloodBanks());
		request.getRequestDispatcher("Admin/UI/BloodBank/bloodbank.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		BloodBankDAO bloodBankDAO = new BloodBankDAO();

		BloodBank bloodBank = new BloodBank(0, request.getParameter("bbname"), request.getParameter("address"),
				request.getParameter("phone"), request.getParameter("remain"));
		bloodBankDAO.addBloodBank(bloodBank);
		doGet(request, response);
	}

}
