package expendables.barney.eventer.model;


public class Event {
	private int mID;
	private int mStartTime;
	private int mEndTime;
	private String mName;
	
	public Event(int id, String name) {
		mID = id;
		mName = name;
	}
	
	public Boolean isHappening() {
		int currentTime = (int)(System.currentTimeMillis() / 1000);
		return (currentTime > mStartTime) && (currentTime < mEndTime);
	}
	
	public String getName() {
		return mName;
	}
}
