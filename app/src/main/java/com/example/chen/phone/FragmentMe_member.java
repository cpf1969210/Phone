package com.example.chen.phone;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 开通会员
 * @author fangxiaoping
 * 2016.3.11
 */
public class FragmentMe_member extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentme_vip);

        //实例化
        ImageView back=(ImageView)findViewById(R.id.back);
        Button open=(Button)findViewById(R.id.open_vip);
        //点击事件
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button open = (Button) findViewById(R.id.open_vip);
                String str = open.getText().toString();
                if (str.contains("开启")) {
                    new AlertDialog.Builder(FragmentMe_member.this)
                            .setTitle("提示")
                            .setMessage("是否确定开启VIP？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    Button open = (Button) findViewById(R.id.open_vip);
                                    open.setText("关闭VIP会员");
                                }

                            })
                            .setNegativeButton("取消", null).show();
                }else{

                    new AlertDialog.Builder(FragmentMe_member.this)
                            .setTitle("提示")
                            .setMessage("是否确定关闭VIP？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO Auto-generated method stub
                                    Button open=(Button)findViewById(R.id.open_vip);
                                    open.setText("开启VIP会员");
                                }

                            })
                            .setNegativeButton("取消", null).show();
                }

            }
        });
    }
}
