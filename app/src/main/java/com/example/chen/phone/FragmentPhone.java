package com.example.chen.phone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 电话界面
 * @author chen
 *         2016/2/26
 */
public class FragmentPhone extends Fragment {
    //声明对象
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num10;
    private Button num11;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(com.example.chen.phone.R.layout.fragement_phone, container, false);
        //绑定对象
        num1=(Button)view.findViewById(R.id.num1);
        num2=(Button)view.findViewById(R.id.num2);
        num3=(Button)view.findViewById(R.id.num3);
        num4=(Button)view.findViewById(R.id.num4);
        num5=(Button)view.findViewById(R.id.num5);
        num6=(Button)view.findViewById(R.id.num6);
        num7=(Button)view.findViewById(R.id.num7);
        num8=(Button)view.findViewById(R.id.num8);
        num9=(Button)view.findViewById(R.id.num9);
        num10=(Button)view.findViewById(R.id.num10);
        num11=(Button)view.findViewById(R.id.num11);
        num0=(Button)view.findViewById(R.id.num0);
        //点击事件
        //数字一
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字二
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字三
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字四
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字五
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字六
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字七
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字八
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字九
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //星号键
        num10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //井号键
        num11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        //数字零号键
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(),Call.class);
                startActivity(intent);
            }
        });
        return view;
    }

}