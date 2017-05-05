package dao;

import static utils.ConnectionUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import pojos.EventPojo;

public class EventDao {
	private Connection con;
	private PreparedStatement pst1, pst2;
	private Statement stmt;

	public EventDao() throws ClassNotFoundException, SQLException {

		con = getConnection();

		this.pst1 = con
				.prepareStatement("insert into events values(?,?,?,?,?,?)");
		this.pst2 = con.prepareStatement("delete from events where eventid=?");

		this.stmt = con.createStatement();

	}

	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();

		if (con != null)
			con.close();
	}

	public String registerevent(EventPojo event) throws Exception {
		String sts = "registration failed";
		// set IN params
		pst1.setInt(1, 0);
		pst1.setString(2, event.getDate());
		pst1.setString(3, event.getTime());
		pst1.setString(4, event.getPresenter());
		pst1.setString(5, event.getDescription());
		pst1.setString(6, event.getTitle());

		// exec
		int updateCount = pst1.executeUpdate();
		if (updateCount == 1)
			sts = "registration successful";
		return sts;

	}

	public int deleteevent(int id) throws SQLException {
		this.pst2.setInt(1, id);

		return this.pst2.executeUpdate();
	}

	public int modifiedData(EventPojo ep) throws SQLException {
		String updsql = "UPDATE events SET date ='" + ep.getDate()
				+ "',time ='" + ep.getTime() + "',presenter = '"
				+ ep.getPresenter() + "',Description = '" + ep.getDescription()
				+ "',title='" + ep.getTitle() + "' WHERE eventid = "
				+ ep.getEventid();
		// this.stmt = con.createStatement();
		stmt.executeUpdate(updsql);

		return 0;
	}

}
