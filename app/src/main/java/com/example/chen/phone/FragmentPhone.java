package com.example.chen.phone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author chen
 *         2016/2/26
 */
public class FragmentPhone extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragement_phone, container, false);
        //获取对象
        Button num1 = (Button) view.findViewById(R.id.num1);
        Button num2 = (Button) view.findViewById(R.id.num2);
        Button num3 = (Button) view.findViewById(R.id.num3);
        Button num4 = (Button) view.findViewById(R.id.num4);
        Button num5 = (Button) view.findViewById(R.id.num5);
        Button num6 = (Button) view.findViewById(R.id.num6);
        Button num7 = (Button) view.findViewById(R.id.num7);
        Button num8 = (Button) view.findViewById(R.id.num8);
        Button num9 = (Button) view.findViewById(R.id.num9);
        Button num0 = (Button) view.findViewById(R.id.num0);
        Button num10 = (Button) view.findViewById(R.id.num10);
        Button num11 = (Button) view.findViewById(R.id.num11);
        /*return inflater.inflate(R.layout.fragement_phone, null);*/
        return view;

    }
}