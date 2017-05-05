package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.EmployeePojo;
import static utils.ConnectionUtils.getConnection;

public class EmpDao {

	private Connection con;
	private PreparedStatement pst1, pst2;

	public EmpDao() throws ClassNotFoundException, SQLException {
		con = getConnection();

		pst1 = con.prepareStatement("insert into register values(?,?,?)");
		pst2 = con
				.prepareStatement("select * from register where emailid=? and password=?");

	}

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();

		if (con != null)
			con.close();
	}

	public String register(EmployeePojo emp) throws Exception {
		String sts = "registration failed";
		// set IN params
		pst1.setString(1, emp.getName());
		pst1.setString(2, emp.getEmailid());
		pst1.setString(3, emp.getPassword());
		// exec
		int updateCount = pst1.executeUpdate();
		if (updateCount == 1)
			sts = "registration successful";
		return sts;

	}

	public boolean login(String email, String pass) throws Exception {
		boolean sts = false;
		// set IN params

		pst2.setString(1, email);
		pst2.setString(2, pass);
		ResultSet rs = pst2.executeQuery();

		sts = rs.next();

		return sts;

	}

}
