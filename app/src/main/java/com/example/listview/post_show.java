package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class post_show extends AppCompatActivity {
    class post {
        private String time;
        private String title;
        private String body;
        private String where;
        private String qq;
        post(String t, String o,String w,String c,String b) {
            time = t;
            where=w;
            body=b;
            qq=c;
            title = o;
        }
        String getTime() {
            return time;
        }
        String getTitle() {
            return title;
        }
        String getWhere(){
            return where;
        }
        String getBody(){
            return body;
        }
        String getQq(){
            return qq;
        }
    }
    ArrayList<post> list=new ArrayList<>();
    ArrayList<String> LIST=new ArrayList<String>();
    private String[] data={"安卓真难写","真难写!真难写!真难写!真难写!真难写!真难写!真难写!","23:41", "安卓","1234566",
            "前端太难了","太难了!太难了!太难了!太难了!太难了!太难了!太难了!","5:50","安卓","1234566",
            "我放弃了","放弃了放弃了放弃了放弃了放弃了放弃了","6:12","安卓","1234566"};//测试数据
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_show_layout);
        Intent intent=getIntent();
        String sort=intent.getStringExtra("extra_data");//从上一个活动得到单子的类别
        TextView textView;
        textView=(TextView)findViewById(R.id.item_sort);
        textView.setText(sort);
        // 根据类别从数据库中提取贴子
        for(int i=0;i<15;i+=5/*判断条件改成数据库是否到末尾*/) {
            String title = data[i];//从数据库中获取标题
            String body=data[i+1];//从数据库中获取详细信息
            String time = data[i+2];//从数据库中获取截止时间
            String where=data[i+3];//从数据库中获取地点
            String qq=data[i+4];//从数据库中获取联系方式
            post T = new post(time,title,where,qq,body);
            list.add(T);
            LIST.add("标题："+title+"\n"+
                    "地点："+where+"\n"+
                    "截止时间："+time+"\n");
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                post_show.this , android.R.layout.simple_list_item_1,
                LIST
        );
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,
                                    int position, long id){
                post_show.post T=list.get(position);
                /*点击后的事件在这里写，跳转到链接之类的*/
                Intent intent1 = new Intent(post_show.this, detail_post.class);
                intent1.putExtra("title",T.getTitle());
                intent1.putExtra("body",T.getBody());
                intent1.putExtra("time",T.getTime());
                intent1.putExtra("qq",T.getQq());
                intent1.putExtra("where",T.getWhere());
                startActivity(intent1);
            }
        });
    }
}
