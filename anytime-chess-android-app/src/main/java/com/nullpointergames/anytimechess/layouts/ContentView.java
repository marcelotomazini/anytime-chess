package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ContentView extends DrawerLayout {

	private NPGToolbar toolbar;
    private RecyclerView recyclerView;
    private BoardLayout boardLayout;
    private GameStatusLayout gameStatusLayout;
    private ButtonsLayout buttonsLayout;

	public ContentView(Context context) {
		super(context);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params1);

		toolbar = new NPGToolbar(context);
        boardLayout = new BoardLayout(context);
        gameStatusLayout = new GameStatusLayout(getContext());
        buttonsLayout = new ButtonsLayout(getContext());

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(toolbar);
        linearLayout.addView(boardLayout);
        linearLayout.addView(gameStatusLayout);
        linearLayout.addView(buttonsLayout);

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

    public void load(String player) {
        try {
            gameStatusLayout.load(player);
            boardLayout.load(player);
            buttonsLayout.load(player);
        } catch (Exception e) {
        }
    }

}
