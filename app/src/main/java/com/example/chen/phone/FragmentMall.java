package com.example.chen.phone;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 商城主页面
 *
 * @author chen
 *         2016/2/26
 */
public class FragmentMall extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragement_mall, container, false);
        //实例化
        //官网
        ImageButton officalwebsite = (ImageButton) view.findViewById(R.id.officalwebsite);
        TextView text_officalwebsite = (TextView) view.findViewById(R.id.text_officalwebsite);
        //在线商城
        ImageButton onlineshoppingmall = (ImageButton) view.findViewById(R.id.onlineshoppingmall);
        TextView text_onlineshoppingmall = (TextView) view.findViewById(R.id.text_onlineshoppingmall);
        //热线
        ImageButton hotline = (ImageButton) view.findViewById(R.id.hotline);
        TextView text_hotline = (TextView) view.findViewById(R.id.text_hotline);
        //常用电话号码
        ImageButton commonnumber=(ImageButton)view.findViewById(R.id.commonnumber);
        TextView text_commonnumber=(TextView)view.findViewById(R.id.text_commonnumber);


        //添加监听
        commonnumber.setOnClickListener(listener);
        text_commonnumber.setOnClickListener(listener);
        hotline.setOnClickListener(listener);
        text_hotline.setOnClickListener(listener);
        officalwebsite.setOnClickListener(listener);
        text_officalwebsite.setOnClickListener(listener);
        onlineshoppingmall.setOnClickListener(listener);
        text_onlineshoppingmall.setOnClickListener(listener);
        return view;

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //官网地址
                case R.id.officalwebsite:
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), FragmentMall_website.class);
                    startActivity(intent);
                    break;
                //官网地址
                case R.id.text_officalwebsite:
                    Intent intent1 = new Intent();
                    intent1.setClass(getActivity(), FragmentMall_website.class);
                    startActivity(intent1);
                    break;
                //在线商城
                case R.id.onlineshoppingmall:
                    Intent intent2 = new Intent();
                    intent2.setClass(getActivity(), FragmentMall_mall.class);
                    startActivity(intent2);
                    break;
                //在线商城
                case R.id.text_onlineshoppingmall:
                    Intent intent3 = new Intent();
                    intent3.setClass(getActivity(), FragmentMall_mall.class);
                    startActivity(intent3);
                    break;
                //咨询热线
                case R.id.hotline:
                    new AlertDialog.Builder(getActivity())
                            .setTitle("提示")
                            .setMessage("确定拨打吗？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    //用intent启动拨打电话
                                    Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "18865274019"));
                                    startActivity(it);
                                }

                            })
                            .setNegativeButton("取消", null).show();
                    break;
                //咨询热线
                case R.id.text_hotline:
                    new AlertDialog.Builder(getActivity())
                            .setTitle("提示")
                            .setMessage("确定拨打吗？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    //用intent启动拨打电话
                                    Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "18865274019"));
                                    startActivity(it);
                                }

                            })
                            .setNegativeButton("取消", null).show();
                    break;
                case R.id.commonnumber:
                    Intent intent4=new Intent();
                    intent4.setClass(getActivity(),FragmentMall_number.class);
                    startActivity(intent4);
                    break;
                case  R.id.text_commonnumber:
                    Intent intent5=new Intent();
                    intent5.setClass(getActivity(),FragmentMall_number.class);
                    startActivity(intent5);
                    break;
            }
        }
    };
}
