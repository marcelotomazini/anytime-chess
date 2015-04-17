package com.nullpointergames.anytimechess.layouts;

import static java.util.Collections.reverse;
import android.content.Context;

import com.nullpointergames.anytimechess.layouts.BoardAdapter;

public class ReverseBoardAdapter extends BoardAdapter {

	public ReverseBoardAdapter(Context context) {
		super(context);
		reverse(itemList);
	}
}
