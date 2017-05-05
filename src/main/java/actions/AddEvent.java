package actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import pojos.EventPojo;
import dao.EventDao;

/**
 * Servlet implementation class AddEvent
 */
public class AddEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EventDao dao;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEvent() throws ClassNotFoundException, SQLException {
		super();

		dao = new EventDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("do post");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("do post");

		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String presenter = request.getParameter("presenter");
		String description = request.getParameter("Description");
		String title = request.getParameter("title");

		EventPojo event = new EventPojo(date, time, presenter, description,
				title);
		RequestDispatcher rd;
		/*
		 * try { if(event==null) {
		 * rd=request.getRequestDispatcher("AddEvents.html");
		 * rd.forward(request, response); } else {
		 */
		try {
			dao.registerevent(event);
			System.out.println("added ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rd = request.getRequestDispatcher("AllTechTalk");
		rd.forward(request, response);
		// }

		/*
		 * } //catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}

}
