package com.example.zhengchengbo.baiduwaimai.Controller.Fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.zhengchengbo.baiduwaimai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengchengbo on 2016/5/7.
 */
@TargetApi(Build.VERSION_CODES.M)
public class OneFragment extends Fragment {
    private ListView listView;
    private Context context;
    private List<Integer> list;
    private MyListViewAdapter adapter;
    private int[] res = new int[]{R.drawable.shopone, R.drawable.shoptwo, R.drawable.shopthree};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_fragment, container, false);
        list=new ArrayList<>();
        for(int i=0;i<res.length;i++){
            list.add(res[i]);
        }
        adapter=new MyListViewAdapter(getActivity(),list);
        listView= (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(adapter);
        return view;
    }


}

