package com.nullpointergames.anytimechess.layouts;

import com.nullpointergames.anytimechess.NavigationDrawerFragment;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;
import android.widget.TableRow;

public class MainLayout extends DrawerLayout {

	private FrameLayout container;
	private NavigationDrawerFragment navigationDrawerFragment;
	
	public MainLayout(Context context) {
		super(context);
		setLayoutParams(new TableRow.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, new Float(1)));
		
		container = new FrameLayout(context);
		navigationDrawerFragment = new NavigationDrawerFragment(context);
		
		addView(container);
	}

	public NavigationDrawerFragment getNavigationDrawerFragment() {
		return navigationDrawerFragment;
	}

}
