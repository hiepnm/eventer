package expendables.barney.eventer.view;

import java.util.List;

import expendables.barney.eventer.R;
import expendables.barney.eventer.model.Event;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class EventerMainActivity extends Activity {
	/*data get from network*/
	private List<Event> mGlobalEvents;
	private List<Event> mOwnerEvents;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		addAllTab();
	}
	
	private void addAllTab() {
		final ActionBar tabBar = getActionBar();
		tabBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		EventPage globalPage = new EventPage(this, mGlobalEvents);
		tabBar.addTab(tabBar.newTab()
				.setText(getResources().getString(R.string.tab_name_global))
				.setTabListener(new TabListener(globalPage)));

		EventPage ownerPage = new EventPage(this, mOwnerEvents);
		tabBar.addTab(tabBar.newTab()
				.setText(getResources().getString(R.string.tab_name_owner))
				.setTabListener(new TabListener(ownerPage)));
	}
	
	public static class TabListener implements ActionBar.TabListener {
		private EventPage mEventPage;

		public TabListener(EventPage page) {
			mEventPage = page;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {

		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			if (null != mEventPage) {
				if (mEventPage.getEventDetailFragment()!=null){
					ft.remove(mEventPage.getEventDetailFragment());
				}
				if (mEventPage.getEventInfoFragment()!=null) {
					ft.replace(R.id.event_fragment_container, mEventPage.getEventInfoFragment());
				}
			}
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (null != mEventPage) {
				if (mEventPage.getEventDetailFragment()!=null){
					ft.remove(mEventPage.getEventDetailFragment());
				}
				if (mEventPage.getEventInfoFragment()!=null) {
					ft.remove(mEventPage.getEventInfoFragment());
				}
			}
		}
	}
}
