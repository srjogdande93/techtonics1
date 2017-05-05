package pojos;

public class EmployeePojo {

	public String name;
	public String emailid;
	public String password;

	public EmployeePojo(String name, String emailid, String password) {
		super();
		this.name = name;
		this.emailid = emailid;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeePojo [name=" + name + ", emailid=" + emailid
				+ ", password=" + password + "]";
	}

}
