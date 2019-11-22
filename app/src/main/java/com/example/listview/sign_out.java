package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_out extends AppCompatActivity {
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//这句判断是如果你的页面继承自AppCompatActivity必须加这句
        setContentView(R.layout.sign_out_layout);

        Button regist=(Button) findViewById(R.id.button_1);
        editText=(EditText)findViewById(R.id.edit_text);
        editText1=(EditText)findViewById(R.id.edit_text1);
        editText2=(EditText)findViewById(R.id.edit_text2);
        editText3=(EditText)findViewById(R.id.edit_text3);
        regist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inputText=editText.getText().toString();//用户名
                String inputText1=editText1.getText().toString();//学号
                String inputText2=editText2.getText().toString();//密码
                String inputText3=editText3.getText().toString();
                if(inputText.length()==0||inputText1.length()==0||inputText2.length()==0)
                    Toast.makeText(sign_out.this,
                            "用户名、密码、学号不能为空",
                            Toast.LENGTH_SHORT).show();
                else
                {
                    if(inputText.equals(""/*数据库中存储的用户名*/))
                    {
                        Toast.makeText(sign_out.this,
                                "用户名已存在",
                                Toast.LENGTH_SHORT).show();
                    }
                    if(inputText2.equals(inputText3))
                    {
                        /*将editText、editText1和editText2存入数据库*/
                        Toast.makeText(sign_out.this,
                                "注册成功",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(sign_out.this,
                                "两次密码不一致",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
