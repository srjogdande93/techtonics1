package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.EmployeePojo;
import dao.EmpDao;

/**
 * Servlet implementation class RegisterServlet
 */
// @WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpDao dao;

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() throws ClassNotFoundException, SQLException {
		super();
		dao = new EmpDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("signup1.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw = response.getWriter();

		// pw.print("in post method");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		EmployeePojo emp = new EmployeePojo(name, email, pass);
		RequestDispatcher rd;
		try {
			if (emp == null) {
				rd = request.getRequestDispatcher("signup1.jsp");
				rd.forward(request, response);
			} else {
				if (email.endsWith("@atmecs.com")) {
					dao.register(emp);
					rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} else {
					System.out.println("in reg else part");

					request.setAttribute("msg", "Use @atmecs.com");
					rd = request.getRequestDispatcher("RegisterServlet");
					this.doGet(request, response);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
