package com.ltm.litaimin.maxim_recipe;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tool.Http_Vegetable;
import tool.Http_comments;
import tool.Http_menuDetail;
import tool.Http_menus;
import tool.Http_postComment;
import tool.Http_support;
import vo.MenuDetail;
import vo.Comment;
import vo.Menuinfo;
import vo.Request_menu;
import vo.Vegetableinfo;

public class MainActivity extends AppCompatActivity {

    //private List<Vegetableinfo> vegetable=new ArrayList<Vegetableinfo>();
    private TextView tv_cs;
    private TextView tv_cs1;
    private TextView tv_cs2;
    private TextView tv_cs3;
    private TextView tv_cs4;
    private TextView tv_cs5;
    private List<Vegetableinfo> vegetable=null;
    private List<Menuinfo> getmenus;
    private MenuDetail getmenus1;
    private String yes;
    private List<Comment> getcomments;
    private String support;
    Handler mHandel=new Handler(){

        @Override
        public void handleMessage(Message msg) {

        StringBuffer is=new StringBuffer();
            for(Vegetableinfo ve: vegetable){
                is.append(ve.getDescription()).append(ve.getTypeid()).append(ve.getTypename()).append(ve.getTypepic());
                System.out.println(is);
            }
//            tv_cs.setText(is.toString());
//            tv_cs1.setText(getmenus.size());
//            tv_cs2.setText(getmenus1.toString());
//            tv_cs3.setText(yes);
//            tv_cs4.setText(getcomments.size());
//            tv_cs5.setText(support);
           // System.out.println(is.toString()+getmenus.size()+getmenus1.toString()+yes+getcomments.size()+support);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initresult();
        initview();
    }
    private void initview() {
        tv_cs = findViewById(R.id.tv_text);
        tv_cs1 = findViewById(R.id.tv_text1);
        tv_cs2 = findViewById(R.id.tv_text2);
        tv_cs3 = findViewById(R.id.tv_text3);
        tv_cs4 = findViewById(R.id.tv_text4);
        tv_cs5 = findViewById(R.id.tv_text5);
        Intent intent=new Intent(getApplicationContext(),HellowActivity.class);
       // startActivity(intent);


      //  Log.i("TAG", String.valueOf(vegetable.size()));
    }
    private void initresult() {
        new Thread(){
            @Override
            public void run() {
                //vegetable=
                vegetable=new ArrayList<Vegetableinfo>();
                vegetable = Http_Vegetable.getVegetable();
//                getmenus = Http_menus.getmenus(new Request_menu(1, 1, 10));
               // getmenus1 = Http_menuDetail.getmenus(1);
               // getcomments = Http_comments.getcomments(1);
               // yes = Http_support.support(1, "yes");
               // support = Http_postComment.support(1, "156315631");
//                Log.i("TAg", String.valueOf(Http_Vegetable.getVegetable().size()));
                mHandel.sendEmptyMessage(0);
            }
        }.start();
    }
}
