package com.example.chen.phone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 电话界面
 * @author chen
 *         2016/2/26
 */
public class FragmentPhone extends Fragment {
    //声明对象
    private ImageView num0;
    private ImageView num1;
    private ImageView num2;
    private ImageView num3;
    private ImageView num4;
    private ImageView num5;
    private ImageView num6;
    private ImageView num7;
    private ImageView num8;
    private ImageView num9;
    private ImageView num10;
    private ImageView num11;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(com.example.chen.phone.R.layout.fragement_phone, container, false);
        //绑定对象
        num1=(ImageView)view.findViewById(R.id.num1);
        num2=(ImageView)view.findViewById(R.id.num2);
        num3=(ImageView)view.findViewById(R.id.num3);
        num4=(ImageView)view.findViewById(R.id.num4);
        num5=(ImageView)view.findViewById(R.id.num5);
        num6=(ImageView)view.findViewById(R.id.num6);
        num7=(ImageView)view.findViewById(R.id.num7);
        num8=(ImageView)view.findViewById(R.id.num8);
        num9=(ImageView)view.findViewById(R.id.num9);
        num10=(ImageView)view.findViewById(R.id.num10);
        num11=(ImageView)view.findViewById(R.id.num11);
        num0=(ImageView)view.findViewById(R.id.num0);
        //点击事件
        //数字一
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "1");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字二
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "2");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字三
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "3");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字四
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "4");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字五
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "5");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字六
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "6");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字七
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "7");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字八
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "8");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字九
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "9");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //星号键
        num10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "*");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //井号键
        num11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "#");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字零号键
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("num", "0");
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        return view;
    }

}