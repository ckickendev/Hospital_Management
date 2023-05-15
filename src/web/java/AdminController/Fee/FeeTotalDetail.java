package web.java.AdminController.Fee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.DispensedMedicationDAO;
import web.java.dao.FeeDAO;
import web.java.dao.PatientDAO;
import web.java.dao.TestResultDAO;

/**
 * Servlet implementation class FeeTotalDetail
 */
@WebServlet("/feeTotal/detail")
public class FeeTotalDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeeTotalDetail() {
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
		FeeDAO feeDAO = new FeeDAO();
		request.setAttribute("fee", feeDAO.findFee((request.getParameter("id"))));
		request.setAttribute("inpatientFee", feeDAO.findInpatientFeeByPatientId(request.getParameter("id")));
		request.setAttribute("medicineFee",
				feeDAO.getMedicineFeeByPatientID(Integer.parseInt(request.getParameter("id"))));
		request.setAttribute("medicineFeeFormat",
				String.format("%.0f", feeDAO.getMedicineFeeByPatientID(Integer.parseInt(request.getParameter("id")))));
		request.setAttribute("testFee", feeDAO.getTestFeeByPatientID(Integer.parseInt(request.getParameter("id"))));

		request.setAttribute("dispenses",
				new DispensedMedicationDAO().findDispenseByPatientId(request.getParameter("id")));
		request.setAttribute("tests", new TestResultDAO().findTestResultByPatientId(request.getParameter("id")));
		request.getRequestDispatcher("../Admin/UI/Fee/feeDetail.jsp").forward(request, response);
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
