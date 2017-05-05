package actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventDao;
import pojos.EventPojo;

/**
 * Servlet implementation class UpdateTechTalk
 */
public class UpdateTechTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EventDao dao;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTechTalk() throws ClassNotFoundException, SQLException {
		super();
		dao = new EventDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in Update Servlet");

		String e2 = request.getParameter("eventid");
		String d2 = request.getParameter("date");
		String t2 = request.getParameter("time");
		String p2 = request.getParameter("presenter");
		String dd2 = request.getParameter("Description");
		String t22 = request.getParameter("title");

		int e3 = Integer.parseInt(e2);

		EventPojo upPojo = new EventPojo(e3, d2, t2, p2, dd2, t22);

		try {
			dao.modifiedData(upPojo);

			System.out.println("new changes saved");

			RequestDispatcher rd = request.getRequestDispatcher("AllTechTalk");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
