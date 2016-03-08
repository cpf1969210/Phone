package com.example.chen.phone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author chen
 * 2016/2/26
 */
public class FragmentMe extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // TODO Auto-generated method stub

         View view=inflater.inflate(R.layout.fragement_me, container, false);
        ImageView login=(ImageView)view.findViewById(R.id.admin_login);
        TextView text_login=(TextView)view.findViewById(R.id.text_login);
        login.setOnClickListener(listener);
        text_login.setOnClickListener(listener);
        return view;

    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.admin_login:
                    Intent intent=new Intent();
                    intent.setClass(getActivity(),FragmentMe_login.class);
                    startActivity(intent);
                    break;
                case R.id.text_login:
                    Intent intent1=new Intent();
                    intent1.setClass(getActivity(),FragmentMe_login.class);
                    startActivity(intent1);
                    break;
            }
        }
    };
    }
