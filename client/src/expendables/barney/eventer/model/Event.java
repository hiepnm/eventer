package expendables.barney.eventer.model;


public class Event {
	private int mID;
	private int mStartTime;
	private int mEndTime;
	private String mName;
	private String mSumary;
	private String mDetail;
	
	public Event(int id, String name, String sumary, String detail) {
		mID = id;
		mName = name;
		mSumary = sumary;
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
