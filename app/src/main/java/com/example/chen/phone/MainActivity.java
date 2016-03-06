package com.example.chen.phone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * 主页面跳转
 *
 * @author chen
 *         2016/2/26
 */
public class MainActivity extends FragmentActivity {

    //声明变量
    private RadioGroup myTabRg;
    private FragmentMall mall;
    private FragmentMe me;
    private FragmentPhone phone;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }
    public void initView() {
        phone = new FragmentPhone();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, phone).commit();
        myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
        myTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rbPhone:
                        phone = new FragmentPhone();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, phone)
                                .commit();
                        break;
                    case R.id.rbRecent:
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, ContactRecordListActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.rbMail:
                        Intent in = new Intent();
                        in.setClass(MainActivity.this, ContactListActivity.class);
                        startActivity(in);
                        break;
                    case R.id.rbMall:
                        mall = new FragmentMall();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, mall)
                                .commit();
                        break;
                    case R.id.rbMe:
                        me = new FragmentMe();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, me)
                                .commit();
                        break;
                    default:
                        break;
                }

            }
        });
    }
}
