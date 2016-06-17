package com.example.zhengchengbo.baiduwaimai.Controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.example.zhengchengbo.baiduwaimai.Controller.Fragment.MyPagerAdapter;
import com.example.zhengchengbo.baiduwaimai.Controller.Fragment.OneFragment;
import com.example.zhengchengbo.baiduwaimai.Controller.Fragment.SecondFragment;
import com.example.zhengchengbo.baiduwaimai.Controller.Fragment.ThridFragment;
import com.example.zhengchengbo.baiduwaimai.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton rb_home, rb_me, rb_order;
    private RadioGroup rd;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    private List<Fragment> list;
    private ActionBar action ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initWiget();
        action.setDisplayShowTitleEnabled(false);
    }


    public void initWiget() {
        rb_home = (ImageButton) findViewById(R.id.ibt_home);
        rb_me = (ImageButton) findViewById(R.id.ibt_me);
        rb_order = (ImageButton) findViewById(R.id.ibt_order);
        rb_home.setOnClickListener(this);
        rb_order.setOnClickListener(this);
        rb_me.setOnClickListener(this);


        toolbar = (Toolbar) findViewById(R.id.tool);
        viewPager = (ViewPager) findViewById(R.id.contain);
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    onPagerChanger();
                }else if(position==1){
                    twoPagerChanger();
                }else if(position==2){
                    threePagerChanger();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setSupportActionBar(toolbar);
        action = getSupportActionBar();
    }

    public void initData() {
        list = new ArrayList<Fragment>();
        list.add(new OneFragment());
        list.add(new ThridFragment());
        list.add(new SecondFragment());
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), MainActivity.this, list);
        action = getSupportActionBar();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibt_home:
                onPagerChanger();
                viewPager.setCurrentItem(0);
                break;
            case R.id.ibt_me:
                threePagerChanger();
                viewPager.setCurrentItem(2);
                break;
            case R.id.ibt_order:
                twoPagerChanger();
                viewPager.setCurrentItem(1);

                break;
        }
    }
    public void onPagerChanger(){
        if (!action.isShowing()) {
            action.show();
        }
        rb_home.setImageResource(R.drawable.tab_icon_home_selected);
        rb_me.setImageResource(R.drawable.tab_icon_me);
        rb_order.setImageResource(R.drawable.tab_icon_dingdan);
    }
    public void twoPagerChanger(){
        if (action.isShowing()) {
            action.hide();
        }
        rb_home.setImageResource(R.drawable.tab_icon_home);
        rb_me.setImageResource(R.drawable.tab_icon_me);
        rb_order.setImageResource(R.drawable.tab_icon_dingdan_selected);
    }
    public void threePagerChanger() {
        if (action.isShowing()) {
            action.hide();
        }
        rb_home.setImageResource(R.drawable.tab_icon_home);
        rb_me.setImageResource(R.drawable.tab_icon_me_selected);
        rb_order.setImageResource(R.drawable.tab_icon_dingdan);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

