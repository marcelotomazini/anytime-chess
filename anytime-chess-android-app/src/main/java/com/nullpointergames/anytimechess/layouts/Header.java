package com.nullpointergames.anytimechess.layouts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.RelativeLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class Header extends RelativeLayout {

    TextView textView;
    CircleImageView circleImageView;

    public Header(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(MATCH_PARENT, 350));
        setBackgroundResource(getResources().getIdentifier("background_chess", "drawable", getContext().getPackageName()));


        textView = new TextView(context);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(16);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText("Anytime Chess");

        circleImageView = new CircleImageView(context);
        circleImageView.setImageResource(getResources().getIdentifier("black_queen_2d_icon", "drawable", getContext().getPackageName()));


        RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textViewLayoutParams.setMargins(30, 0, 0, 30);

        RelativeLayout.LayoutParams circleImageViewLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        circleImageViewLayoutParams.setMargins(30, 100, 0, 0);


        addView(circleImageView, circleImageViewLayoutParams);
        addView(textView, textViewLayoutParams);
    }
}
