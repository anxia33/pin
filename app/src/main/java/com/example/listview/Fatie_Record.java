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
import android.widget.Toast;

import java.util.ArrayList;

public class Fatie_Record extends AppCompatActivity {
//    Intent intent=getIntent();
//    int ID=intent.getIntExtra("ID",0);
    private int ID;
    class tiezi {
        tiezi(int ID,String t, String o) {
            id=ID;
            time = t;
            title = o;
        }
        int getId(){
            return id;
        }
        String getTime() {
            return time;
        }
        String getTitle() {
            return title;
        }
        private int id;
        private String time;
        private String title;
    }
    ArrayList<tiezi> list=new ArrayList<tiezi>();
    ArrayList<String> LIST=new ArrayList<String>();
    private String[] data={"安卓真难写","23:41","前端太难了","5:50",
    "我放弃了","6:12","啊我死了","8:50"};//测试数据
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        global g=new global();
        ID=g.ID;
        setContentView(R.layout.activity_fatie__record);
        for(int i=0;i<8;i+=2/*判断条件改成数据库是否到末尾*/) {
            String title = data[i];//从数据库中获取
            String time = data[i+1];//从数据库中获取
            tiezi T = new tiezi(ID,time, title);
            list.add(T);
            LIST.add(title+"\n"+ID+"\n"+time);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                Fatie_Record.this , android.R.layout.simple_list_item_1,
                LIST
        );
        ListView listView=(ListView)findViewById(R.id.list_view1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,
                                    int position, long id){
                tiezi T=list.get(position);
                /*点击后的事件在这里写，跳转到链接之类的*/
                Toast.makeText(Fatie_Record.this,
                        T.getTitle()+"\n"+T.getTime(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
