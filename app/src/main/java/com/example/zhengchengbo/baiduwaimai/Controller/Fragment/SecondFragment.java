package com.example.zhengchengbo.baiduwaimai.Controller.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.zhengchengbo.baiduwaimai.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengchengbo on 2016/5/7.
 */
public class SecondFragment extends android.support.v4.app.Fragment{
    private ListView listView;
    private ImageButton imageButton;
    private TextView textView;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> list;
    private List<View> lsView;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.second_fragment,container,false);
        initData();
        initWidget(view);
        return view;
    }
   public void  initWidget(View view){
//       initData();
       listView= (ListView) view.findViewById(R.id.second_fragment_listViewOne);
       imageButton= (ImageButton) view.findViewById(R.id.second_fragment_item_imageBotton);
       textView= (TextView) view.findViewById(R.id.second_fragment_item_textView);
       listView.setAdapter(simpleAdapter);

   }
    public  void initData(){
        list=new ArrayList<Map<String,Object>>();
        String textViewText[]=new String[]{"我的送餐地址","我的代金券","我的退款","我的消息","我的收藏","我的评论","百度钱包","百度糯米"};
        int imageSrcNumber[]=new int[]{R.drawable.mypage_list_icon_location,R.drawable.mypage_list_icon_daijinjuan,R.drawable.mypage_list_icon_refund,R.drawable.my_messages,R.drawable.mypage_list_icon_star,R.drawable.mypage_list_icon_comment,R.drawable.my_balance_icon,R.drawable.icon_nuomi};
        for(int i=0;i<textViewText.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("imag",imageSrcNumber[i]);
            map.put("text",textViewText[i]);
            list.add(map);
        }
        simpleAdapter=new SimpleAdapter(getActivity(),list,R.layout.second_fragment_listview_item,new String[]{"imag","text"},new int[]{R.id.second_fragment_item_imageBotton,R.id.second_fragment_item_textView});

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        listView=null;
        list=null;
        simpleAdapter=null;
    }
}
