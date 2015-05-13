package expendables.barney.eventer.view;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class EventInfoFragment extends ListFragment {
	private EventPage mParent = null;
	EventListAdapter mAdapter;

	public EventInfoFragment(EventPage parent) {
		mParent = parent;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		mAdapter = new EventListAdapter(activity.getApplicationContext(), mParent.getListEvent());
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(mAdapter);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		getListView().setItemChecked(position, true);
		mParent.onItemSelected(position);
	}
}
