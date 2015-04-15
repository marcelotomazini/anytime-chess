package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContentView extends DrawerLayout {

	private NPGToolbar toolbar;
    private LinearLayout linearLayout;
    private RecyclerView recyclerView;

	public ContentView(Context context) {
		super(context);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params1);
        setElevation(7);

		toolbar = new NPGToolbar(context);

        linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        TextView textView = new TextView(context);
        textView.setText("opa");

        linearLayout.addView(toolbar);
        linearLayout.addView(textView);

        recyclerView = new RecyclerView(context);
        recyclerView.setBackgroundColor(Color.WHITE);
        DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(500, LinearLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.START;
        recyclerView.setLayoutParams(params);

        addView(linearLayout);
        addView(recyclerView);
    }
	
	public NPGToolbar getToolbar() {
		return toolbar;
	}

	public RecyclerView getRecyclerView() {
		return recyclerView;
	}

}
