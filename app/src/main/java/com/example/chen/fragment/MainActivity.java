package com.example.chen.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.example.chen.phone.R;

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
    private FragmentMaillist fragmentMaillist;
    private FragmentRecent fragmentRecent;


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
                        fragmentRecent=new FragmentRecent();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragmentRecent)
                                .commit();
                        break;
                    case R.id.rbMail:
                        fragmentMaillist=new FragmentMaillist();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, fragmentMaillist)
                                .commit();
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
