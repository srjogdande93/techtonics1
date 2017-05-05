package actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.EventPojo;
import dao.EmpDao;
import utils.ConnectionUtils;

/**
 * Servlet implementation class AllTechTalk
 */
public class AllTechTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpDao dao;
	Connection con;
	Statement stmt;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public AllTechTalk() throws ClassNotFoundException, SQLException {
		super();
		dao = new EmpDao();
		con = ConnectionUtils.getConnection();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AllTechTalk in post");
		try {
			con = ConnectionUtils.getConnection();
			ArrayList al = null;
			String sql = "select * from events";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			al = new ArrayList();

			while (rs.next()) {

				EventPojo event = new EventPojo(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

				al.add(event);
			}

			request.setAttribute("tecktalkList", al);
			con.close();
			request.getRequestDispatcher("AdminTechTalk.jsp").forward(request,
					response);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
