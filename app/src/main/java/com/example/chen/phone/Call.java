package com.example.chen.phone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Call extends AppCompatActivity implements View.OnClickListener {
    //定义对象
    private ListView listView;
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
    private TextView phonenum;
    boolean visibility_Flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call);
        //绑定对象
        listView = (ListView) findViewById(R.id.contactList);
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
        phonenum = (TextView) findViewById(R.id.phonenum);
        final Button eject = (Button) findViewById(R.id.eject);
        final LinearLayout T9 = (LinearLayout) findViewById(R.id.T9);
        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (visibility_Flag) {
                    T9.setVisibility(View.INVISIBLE);
                    eject.setBackgroundDrawable(getResources().getDrawable(R.drawable.eject));
                    visibility_Flag = false;
                } else {
                    T9.setVisibility(View.VISIBLE);
                    eject.setBackgroundDrawable(getResources().getDrawable(R.drawable.hide));
                    visibility_Flag = true;
                }
            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num1:
                phonenum.setText("1");

     /*  if (editText.getText().length() < 12) {
                    input(v.getTag().toString());
                }*/

                break;
        }
    }

   /* private void input(String str) {
        int c = editText.getSelectionStart();
        String p = editText.getText().toString();
        editText.setText(p.substring(0, c) + str + p.substring(editText.getSelectionStart(), p.length()));
        editText.setSelection(c + 1, c + 1);
    }

    private void delete() {
        int c = editText.getSelectionStart();
        if (c > 0) {
            String p = editText.getText().toString();
            editText.setText(p.substring(0, c - 1) + p.substring(editText.getSelectionStart(), p.length()));
            editText.setSelection(c - 1, c - 1);
        }
    }*/

}
