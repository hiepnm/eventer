package expendables.barney.eventer.view;


import expendables.barney.eventer.R;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

public class EventDetailFragment extends Fragment {
	private TextView mDetailEventTextView = null;
	private int mCurrentIndex = -1;
	private EventPage mParent;
	
	public EventDetailFragment(EventPage parent) {
		mParent = parent;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mDetailEventTextView = (TextView)getActivity().findViewById(R.id.detail_event);
	}
	
	public int getShownIndex() {
		return mCurrentIndex;
	}
	
	public void showEventDetailAtIndex(int newIndex) {
		if (newIndex < 0 || newIndex >= mParent.getListEvent().size()) {
			return;
		}
		mCurrentIndex = newIndex;
		mDetailEventTextView.setText(mParent.getListEvent().get(mCurrentIndex).getDetail());
	}
}
