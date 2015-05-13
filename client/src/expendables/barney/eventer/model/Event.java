package expendables.barney.eventer.model;


public class Event {
	private int mID;
	private int mStartTime;
	private int mEndTime;
	private String mName;
	private String mDetail;
	
	public Event(int id, String name, String detail) {
		mID = id;
		mName = name;
		mDetail = detail;
	}
	
	public Boolean isHappening() {
		int currentTime = (int)(System.currentTimeMillis() / 1000);
		return (currentTime > mStartTime) && (currentTime < mEndTime);
	}
	
	public String getName() {
		return mName;
	}
	
	public String getDetail() {
		return mDetail;
	}
}
