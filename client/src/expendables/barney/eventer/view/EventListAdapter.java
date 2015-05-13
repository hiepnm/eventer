package expendables.barney.eventer.view;

import java.util.List;

import expendables.barney.eventer.R;
import expendables.barney.eventer.model.Event;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

public class EventListAdapter extends BaseAdapter {
	private final List<Event> mEvents;
	private final Context mContext;
	
	public EventListAdapter(Context context, List<Event> listEvent) {
		mEvents = listEvent;
		mContext = context;
	}
	
	public void add(Event event) {
		mEvents.add(event);
		notifyDataSetChanged();
	}
	public void clear() {
		mEvents.clear();
		notifyDataSetChanged();
	}
	@Override
	public int getCount() {
		return mEvents.size();
	}

	@Override
	public Object getItem(int pos) {
		return mEvents.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Event event = (Event)getItem(position);
		LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		RelativeLayout eventItemLayout = (RelativeLayout)inflater.inflate(R.id.item_event_info, parent, false);
		/*draw some*/
		return eventItemLayout;
	}

}
