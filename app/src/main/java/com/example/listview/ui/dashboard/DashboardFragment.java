package com.example.listview.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.listview.R;
import com.example.listview.global;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private EditText time;
    private EditText title;
    private EditText addr;
    private EditText tel;
    private EditText detail;
    private Spinner spinner;
    private Button b1;
    private int ID;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*Bundle bundle=this.getArguments();
        ID=bundle.getInt("ID");*/
        global g=new global();
        ID=g.ID;
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button b1=(Button) view.findViewById(R.id.issue);
        title = (EditText) view.findViewById(R.id.title);
        time = (EditText) view.findViewById(R.id.time);
        addr = (EditText) view.findViewById(R.id.addr);
        tel = (EditText) view.findViewById(R.id.tel);
        detail = (EditText) view.findViewById(R.id.detail);
        spinner=(Spinner) view.findViewById(R.id.sort);
        spinner = (Spinner) view.findViewById(R.id.sort);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title1 = title.getText().toString();
                String time1 = time.getText().toString();
                String addr1 = addr.getText().toString();
                String tel1 = tel.getText().toString();
                String sort =spinner.getSelectedItem().toString();//获取类别
                String detail1 = detail.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                String futime  = formatter.format(curDate);
                Toast.makeText(getActivity(),"发布成功，用户ID："+ID,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    }