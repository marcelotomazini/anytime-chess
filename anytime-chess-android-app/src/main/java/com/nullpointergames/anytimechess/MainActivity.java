package com.nullpointergames.anytimechess;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.nullpointergames.anytimechess.layouts.MainLayout;
import com.nullpointergames.anytimechess.utils.Messages;

public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	private NavigationDrawerFragment mNavigationDrawerFragment;

	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainLayout layout = new MainLayout(getApplicationContext());
		setContentView(layout);

		mNavigationDrawerFragment = layout.getNavigationDrawerFragment();
		mTitle = getTitle();

		mNavigationDrawerFragment.setUp(layout, this);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
//		FragmentManager fragmentManager = getSupportFragmentManager();
//		fragmentManager
//				.beginTransaction()
//				.replace(1,
//						PlaceholderFragment.newInstance(position + 1)).commit();
	}

//	public void onSectionAttached(int number) {
//		switch (number) {
//		case 1:
//			mTitle = getString(R.string.title_section1);
//			break;
//		case 2:
//			mTitle = getString(R.string.title_section2);
//			break;
//		case 3:
//			mTitle = getString(R.string.title_section3);
//			break;
//		}
//	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			menu.add(0, 0, 0, Messages.getString("new.game")); 
			menu.add(0, 0, 0, Messages.getString("about")); 
			
			restoreActionBar();
//			return true;
//		}
		return super.onCreateOptionsMenu(menu);
	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}

}
