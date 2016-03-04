package com.example.chen.phone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class Call extends AppCompatActivity {
    //定义对象
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11;
    private TextView phonenum;
    boolean visibility_Flag = false;//标识符

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);

        //绑定对象
        //弹出隐藏按键
        final Button eject = (Button) findViewById(R.id.eject);
        //键盘线性布局
        final LinearLayout T9 = (LinearLayout) findViewById(R.id.T9);
        final LinearLayout line = (LinearLayout) findViewById(R.id.line);
        final LinearLayout phonedata = (LinearLayout) findViewById(R.id.phonedata);
        //拨打电话
        Button dial = (Button) findViewById(R.id.dial);
        //删除按键
        Button delete = (Button) findViewById(R.id.delete);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        num10 = (Button) findViewById(R.id.num10);
        num11 = (Button) findViewById(R.id.num11);
        num0 = (Button) findViewById(R.id.num0);
        num0.setOnClickListener(listener);
        num1.setOnClickListener(listener);
        num2.setOnClickListener(listener);
        num3.setOnClickListener(listener);
        num4.setOnClickListener(listener);
        num5.setOnClickListener(listener);
        num6.setOnClickListener(listener);
        num7.setOnClickListener(listener);
        num8.setOnClickListener(listener);
        num9.setOnClickListener(listener);
        num10.setOnClickListener(listener);
        num11.setOnClickListener(listener);
        delete.setOnClickListener(listener);
        dial.setOnClickListener(listener);
        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (visibility_Flag) {
                    T9.setVisibility(View.INVISIBLE);
                    line.setVisibility(View.INVISIBLE);
                    phonedata.setVisibility(View.INVISIBLE);
                    eject.setBackgroundDrawable(getResources().getDrawable(R.drawable.eject));
                    visibility_Flag = false;
                } else {
                    T9.setVisibility(View.VISIBLE);
                    line.setVisibility(View.VISIBLE);
                    phonedata.setVisibility(View.VISIBLE);
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.setText("");
                    eject.setBackgroundDrawable(getResources().getDrawable(R.drawable.hide));
                    visibility_Flag = true;
                }
            }
        });
    }
    //键盘点击事件
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.num0:

                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("0");
                    break;
                case R.id.num1:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("1");
                    break;
                case R.id.num2:

                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("2");
                    break;
                case R.id.num3:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("3");
                    break;
                case R.id.num4:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("4");
                    break;
                case R.id.num5:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("5");
                    break;
                case R.id.num6:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("6");
                    break;
                case R.id.num7:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("7");
                    break;
                case R.id.num8:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("8");
                    break;
                case R.id.num9:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("9");
                    break;
                case R.id.num10:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("*");
                    break;
                case R.id.num11:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    phonenum.append("#");
                    break;
                case R.id.delete:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    String string = phonenum.getText().toString();
                    if (string.length() == 0) {
                        phonenum.setText("");
                        break;
                    } else {
                        phonenum.setText(string.substring(0, string.length() - 1));
                        break;
                    }
                case R.id.dial:
                    phonenum = (TextView) findViewById(R.id.phonenum);
                    String num = phonenum.getText().toString();
                    //用intent启动拨打电话
                    Intent it = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num));
                    startActivity(it);
                    break;
                default:
                    break;
            }
        }
    };
}
