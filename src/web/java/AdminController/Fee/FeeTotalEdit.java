package web.java.AdminController.Fee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.FeeDAO;
import web.java.dao.PatientDAO;
import web.java.model.Fee;

/**
 * Servlet implementation class FeeTotalEdit
 */
@WebServlet("/feeTotal/edit")
public class FeeTotalEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeeTotalEdit() {
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
		request.setAttribute("patients", new PatientDAO().getPatients());
		request.setAttribute("feeTotal", new FeeDAO().findFee(request.getParameter("id")));
		request.getRequestDispatcher("../Admin/UI/Fee/feeEdit.jsp").forward(request, response);
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
		System.out.println("id:" + request.getParameter("id"));
		System.out.println("price:" + request.getParameter("price"));
		System.out.println("date:" + request.getParameter("date"));
		Fee fee = new FeeDAO().findFeeByPatient(request.getParameter("id"));
		if (fee == null) {
			new FeeDAO().addFee(new Fee(Integer.parseInt(request.getParameter("id")),
					Integer.parseInt(request.getParameter("id")), Float.parseFloat(request.getParameter("price")),
					request.getParameter("date"), Integer.parseInt(request.getParameter("status"))));
		} else {
			new FeeDAO().updateFee(new Fee(Integer.parseInt(request.getParameter("id")),
					Integer.parseInt(request.getParameter("id")), Float.parseFloat(request.getParameter("price")),
					request.getParameter("date"), Integer.parseInt(request.getParameter("status"))));
		}
		doGet(request, response);
	}

}
