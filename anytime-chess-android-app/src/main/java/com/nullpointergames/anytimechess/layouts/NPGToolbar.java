package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

public class NPGToolbar extends Toolbar {

	public NPGToolbar(Context context) {
		super(context);
        setBackgroundResource(getResources().getIdentifier("ColorPrimary", "color", context.getPackageName()));
        setElevation(4);
        setPadding(0, 45, 0, 0);

        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
	}

}
