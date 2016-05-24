package com.puyang.animation;

/**
 * Created by yangpu on 2/22/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.puyang.R;

public class AnimationListAdapter extends BaseAdapter{
    LayoutInflater inflater;
    Context context;
    String[] listItems;


    public AnimationListAdapter(Context context) {
        this.context = context;
        listItems = context.getResources().getStringArray(R.array.animation_list);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listItems.length;
    }

    @Override
    public Object getItem(int position) {
        return listItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;

        if (null == convertView) {
            itemView = inflater.inflate(R.layout.animation_list_textview, null);
        } else {
            itemView = convertView;
        }

        TextView textView = (TextView) itemView.findViewById(R.id.animationListTextview);
        textView.setText(listItems[position]);
        return itemView;
    }

}

