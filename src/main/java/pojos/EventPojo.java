package pojos;

public class EventPojo {

	int eventid;
	String date;
	String time;
	String presenter;
	String Description;
	String title;

	public EventPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventPojo(int eventid, String date, String time, String presenter,
			String description, String title) {
		super();
		this.eventid = eventid;
		this.date = date;
		this.time = time;
		this.presenter = presenter;
		Description = description;
		this.title = title;
	}

	public EventPojo(String date, String time, String presenter,
			String description, String title) {
		super();
		this.date = date;
		this.time = time;
		this.presenter = presenter;
		Description = description;
		this.title = title;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "EventPojo [eventid=" + eventid + ", date=" + date + ", time="
				+ time + ", presenter=" + presenter + ", Description="
				+ Description + ", title=" + title + "]";
	}

}
