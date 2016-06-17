package com.example.zhengchengbo.baiduwaimai.Controller.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.zhengchengbo.baiduwaimai.R;

import java.util.List;

/**
 * Created by zhengchengbo on 2016/5/11.
 */
public class MyListViewAdapter extends BaseAdapter {
    public MyListViewAdapter(Context context, List<Integer> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    private LayoutInflater inflater;
    private List<Integer> list;

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1 = null;
        int type = getItemViewType(position);
        switch (type) {
            case 0:
                View view = inflater.inflate(R.layout.one_fragment_listview_item, null);
                return view;
            case 1:
                if (convertView == null) {
                    viewHolder1 = new ViewHolder1();
                    convertView = inflater.inflate(R.layout.one_fragment_listview_anotheritem, null);
                    viewHolder1.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                    convertView.setTag(viewHolder1);
                }
                viewHolder1= (ViewHolder1) convertView.getTag();
                viewHolder1.imageView.setImageResource(list.get(position%2));
        }
        return convertView;

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    private class ViewHolder1 {
        ImageView imageView;
    }

}


