package com.nullpointergames.anytimechess;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.nullpointergames.anytimechess.layouts.Header;
import com.nullpointergames.anytimechess.layouts.Item;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private List<String> mNavTitles;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int Holderid;

        Item textView;

        public ViewHolder(View itemView,int ViewType) {
            super(itemView);

            if(ViewType == TYPE_ITEM) {
                textView = (Item) itemView;
                Holderid = 1;
            }
            else{
                Holderid = 0;
            }
        }
    }



    MyAdapter(List<String> titles){
        mNavTitles = titles;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View v = new Item(parent.getContext());
            return new ViewHolder(v,viewType);
        } else if (viewType == TYPE_HEADER) {
            View v = new Header(parent.getContext());
            return new ViewHolder(v,viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        if(holder.Holderid ==1)
            holder.textView.setText(mNavTitles.get(position - 1));
    }

    @Override
    public int getItemCount() {
        return mNavTitles.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

}