package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Item extends LinearLayout {

    TextView txt;

    public Item(Context context) {
        super(context);
        setPadding(0, 8, 0, 8);
        setOrientation(LinearLayout.HORIZONTAL);
        setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        txt = new TextView(context);
        txt.setTextAppearance(context, android.R.style.TextAppearance_Large);
        txt.setPadding(4, 4, 0, 0);

        addView(txt);
    }

    public void setText(final String text) {
        txt.setText(text);
    }
}
