package com.example.chen.phone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 常用电话界面
 * @author CHEN
 * 2016.3.9
 */
public class FragmentMall_number extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentmall_number);
        //实例化
        ImageView back=(ImageView)findViewById(R.id.back);
        //出行
        TextView air_Hotel=(TextView)findViewById(R.id.Air_Hotel);
        TextView hotel=(TextView)findViewById(R.id .Hotel);
        //交通
        TextView taxi=(TextView)findViewById(R.id.taxi);
        TextView other_drive=(TextView)findViewById(R.id.other_drive);
        TextView car_rental=(TextView)findViewById(R.id.car_rental);
        //金融
        TextView bank=(TextView)findViewById(R.id.bank);
        TextView negotiable_securities=(TextView)findViewById(R.id.negotiable_securities);
        TextView investment=(TextView)findViewById(R.id.investment);
        TextView Insurance=(TextView)findViewById(R.id.Insurance);
        //客服
        TextView business_customer=(TextView)findViewById(R.id.business_customer);
        TextView game_customer=(TextView)findViewById(R.id.game_customer);
        TextView brand_customer=(TextView)findViewById(R.id.brand_customer);
        //公共
        TextView Alarm_rescue=(TextView)findViewById(R.id.Alarm_rescue);
        TextView public_service=(TextView)findViewById(R.id.public_service);
        TextView Hotline=(TextView)findViewById(R.id.Hotline);
        TextView charitable=(TextView)findViewById(R.id.charitable);

        //监听事件
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
