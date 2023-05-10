package web.java.AdminController.Fee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.HospitalFeeDAO;
import web.java.model.HospitalFee;

/**
 * Servlet implementation class FeeEdit
 */
@WebServlet("/service/edit")
public class FeeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeeEdit() {
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
		request.setAttribute("service", new HospitalFeeDAO().findHospitalFee(request.getParameter("id")));
		request.getRequestDispatcher("../Admin/UI/HospitalFee/serviceEdit.jsp").forward(request, response);
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
		new HospitalFeeDAO().updateHospitalFee(
				new HospitalFee(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),
						Float.parseFloat(request.getParameter("price")), request.getParameter("notes")));
		response.sendRedirect("http://localhost:8080/Hospital_Management/service");
	}

}
