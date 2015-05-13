package expendables.barney.eventer.view;

import java.util.List;

import expendables.barney.eventer.R;
import expendables.barney.eventer.model.Event;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class EventPage {
	private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	
	private EventInfoFragment mEventInfoFragment;
	private EventDetailFragment mEventDetailFragment;
	private Activity mParent;
	private FragmentManager mFragmentManager;
	private FrameLayout mInfoLayout, mDetailLayout;
	private List<Event> mEvents;
	
	public EventPage(Activity parent, List<Event> events) {
		mParent = parent;
		mEvents = events;
		mEventInfoFragment = new EventInfoFragment(this);
		mEventDetailFragment = new EventDetailFragment(this);
		mFragmentManager = mParent.getFragmentManager();
		mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
			@Override
			public void onBackStackChanged() {
				setLayout();
			}
		});
	}
	
	protected void setLayout() {
		// TODO set Layout when backtrack change.
		if (!mEventDetailFragment.isAdded()) {
			// Make the EventInfoFragment occupy the entire layout 
			mInfoLayout.setLayoutParams(new LinearLayout.LayoutParams( MATCH_PARENT, MATCH_PARENT));
			mDetailLayout.setLayoutParams(new LinearLayout.LayoutParams(0, MATCH_PARENT));
		} else {
			// Make the EventDetailFragment occupy the entire layout 
			mInfoLayout.setLayoutParams(new LinearLayout.LayoutParams( 0, MATCH_PARENT));
			mDetailLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
		}
	}

	public List<Event> getListEvent() {
		return mEvents;
	}
	
	public void onAddEventInfoFragment() {
		FragmentTransaction ft = mFragmentManager.beginTransaction();
		ft.add(R.id.event_fragment_container, mEventInfoFragment);
		ft.commit();
	}
	
	public Fragment getEventInfoFragment() {
		return mEventInfoFragment;
	}
	public Fragment getEventDetailFragment() {
		return mEventDetailFragment;
	}

	public void onItemSelected(int position) {
		if (!mEventDetailFragment.isAdded()) {
			FragmentTransaction ft = mFragmentManager.beginTransaction();
			ft.add(R.id.detail_fragment_container, mEventDetailFragment);
			ft.addToBackStack(null);
			ft.commit();
			mFragmentManager.executePendingTransactions();
		}
		
		if (mEventDetailFragment.getShownIndex() != position){
			mEventDetailFragment.showEventDetailAtIndex(position);
		}
	}
	
}
