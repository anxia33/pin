package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends AppCompatActivity implements View.OnClickListener{

    private EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }//这句判断是如果你的页面继承自AppCompatActivity必须加这句

        setContentView(R.layout.sign_in_layout);

        Button sign_in=(Button)findViewById(R.id.sign_in);
        Button sign_out=(Button)findViewById(R.id.sign_out);
        editText1=(EditText)findViewById(R.id.username);
        editText2=(EditText)findViewById(R.id.password);
        sign_in.setOnClickListener(this);
        sign_out.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in:
                String user=editText1.getText().toString(); //用户名
                String passward=editText2.getText().toString();//密码
                if(user.isEmpty()||passward.isEmpty())
                    Toast.makeText(sign_in.this,"账号或密码为空",Toast.LENGTH_SHORT).show();
                else {

                    /*从数据库读取数据，判断账号密码是否正确，若正确则进入主界面*/
                    int ID=123;//从数据库中根据用户名对照，若用户名属于表中第k个元组，则ID=k；
                    Intent intent=new Intent(sign_in.this,MainActivity.class);//跳转至主界面
                    //intent.putExtra("ID",ID);
                    global g=new global();
                    g.ID=ID;
                    startActivity(intent);
                    Toast.makeText(sign_in.this,"登录成功,用户ID:"+ID,Toast.LENGTH_SHORT).show();
                    sign_in.this.finish();
                }
                break;
            case R.id.sign_out:
                Intent intent=new Intent(sign_in.this,sign_out.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
