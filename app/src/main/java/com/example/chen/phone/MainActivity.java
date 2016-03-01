package com.example.chen.phone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

/**
 * @author chen
 * 2016/2/26
 */
public class MainActivity extends FragmentActivity {

    //声明变量
    private Fragment contentFragment;
    private RadioGroup myTabRg;
    private FragementMaillist maillist;
    private FragementMall mall;
    private FragementMe me;
    private FragementPhone phone;
    private FragementRecentCalls recent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();

    }
    public void initView() {
        phone = new FragementPhone();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, phone).commit();
        myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
        myTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rbPhone:
                        phone = new FragementPhone();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, phone)
                                .commit();
                        break;
                    case R.id.rbRecent:
//                        if (recent == null) {
//                            recent = new FragementRecentCalls();
//                        }
                        recent = new FragementRecentCalls();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, recent)
                                .commit();
                        break;
                    case R.id.rbMail:
                        maillist = new FragementMaillist();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, maillist)
                                .commit();
                        break;
                    case R.id.rbMall:
                        mall = new FragementMall();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, mall)
                                .commit();
                        break;
                    case R.id.rbMe:
                        me = new FragementMe();
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
