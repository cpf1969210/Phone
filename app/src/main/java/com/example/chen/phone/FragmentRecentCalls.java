package com.example.chen.phone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author chen
 * 2016/2/26
 */
public class FragmentRecentCalls extends Fragment {
    private ListView callLogListView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return   inflater.inflate(R.layout.fragement_recent_calls, container, false);

        /*return inflater.inflate(R.layout.fragement_recent_calls, null);*/
    }
}
