package com.example.zhengchengbo.baiduwaimai.Controller.Fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

/**
 * Created by zhengchengbo on 2016/5/9.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private Context context;
    public MyPagerAdapter(FragmentManager fm,Context context,List<Fragment> list) {
        super(fm);
        this.context=context;
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }


}
