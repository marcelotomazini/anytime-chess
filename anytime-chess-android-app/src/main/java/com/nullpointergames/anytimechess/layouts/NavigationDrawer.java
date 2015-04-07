package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.widget.ListView;

public class NavigationDrawer extends ListView {

	public NavigationDrawer(Context context) {
		super(context);
		setLayoutParams(new DrawerLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1));
	}
}
