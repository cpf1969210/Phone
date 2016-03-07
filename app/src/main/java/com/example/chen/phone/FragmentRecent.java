package com.example.chen.phone;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.example.chen.adapter.DialAdapter;
import com.example.chen.model.CallLogBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 最近通话界面
 * @author CHEN
 * 2016.3.7
 */
public class FragmentRecent extends Fragment {
    //声明变量
    private RadioGroup myTabRg;
    private ListView callLogListView;
    private AsyncQueryHandler asyncQuery;
    private DialAdapter adapter;
    private List<CallLogBean> callLogs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // TODO Auto-generated method stub

         View view=inflater.inflate(R.layout.fragment_recent, container, false);
        callLogListView = (ListView) view.findViewById(R.id.call_log_list);
        asyncQuery = new MyAsyncQueryHandler(getActivity().getContentResolver());
        init();
/*
        initView();
*/
        return view;

    }
  /*  public void initView() {
        myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
        myTabRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.rbPhone:
                        Intent inten = new Intent();
                        inten.setClass(ContactRecordListActivity.this, MainActivity.class);
                        startActivity(inten);
                        break;
                    case R.id.rbRecent:
                        Intent intent = new Intent();
                        intent.setClass(ContactRecordListActivity.this, ContactRecordListActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.rbMail:
                        Intent in = new Intent();
                        in.setClass(ContactRecordListActivity.this, ContactListActivity.class);
                        startActivity(in);
                        break;
                    case R.id.rbMall:
                        Intent inte = new Intent();
                        inte.putExtra("mall", "mall");
                        inte.setClass(ContactRecordListActivity.this, MainActivity.class);
                        startActivity(inte);
                        break;
                    case R.id.rbMe:
                        Intent ite = new Intent();
                        ite.putExtra("me","me");
                        ite.setClass(ContactRecordListActivity.this, MainActivity.class);
                        startActivity(ite);
                        break;
                    default:
                        break;
                }

            }
        });
    }*/

    private void init() {
        Uri uri = CallLog.Calls.CONTENT_URI;
        // 查询的列
        String[] projection = {CallLog.Calls.DATE, // 日期
                CallLog.Calls.NUMBER, // 号码
                CallLog.Calls.TYPE, // 类型
                CallLog.Calls.CACHED_NAME, //名字
                CallLog.Calls._ID, // id
        };
        asyncQuery.startQuery(0, null, uri, projection, null, null,
                CallLog.Calls.DEFAULT_SORT_ORDER);
    }

    private class MyAsyncQueryHandler extends AsyncQueryHandler {

        public MyAsyncQueryHandler(ContentResolver cr) {
            super(cr);
        }

        @Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                callLogs = new ArrayList<CallLogBean>();
                SimpleDateFormat sfd = new SimpleDateFormat("MM-dd hh:mm");
                Date date;
                cursor.moveToFirst(); // 游标移动到第一项
                for (int i = 0; i < cursor.getCount(); i++) {
                    cursor.moveToPosition(i);
                    date = new Date(cursor.getLong(cursor
                            .getColumnIndex(CallLog.Calls.DATE)));
                    String number = cursor.getString(cursor
                            .getColumnIndex(CallLog.Calls.NUMBER));
                    int type = cursor.getInt(cursor
                            .getColumnIndex(CallLog.Calls.TYPE));
                    String cachedName = cursor.getString(cursor
                            .getColumnIndex(CallLog.Calls.CACHED_NAME));//缓存的名称与电话号码，如果它的存在
                    int id = cursor.getInt(cursor
                            .getColumnIndex(CallLog.Calls._ID));

                    CallLogBean callLogBean = new CallLogBean();
                    callLogBean.setId(id);
                    callLogBean.setNumber(number);
                    callLogBean.setName(cachedName);
                    if (null == cachedName || "".equals(cachedName)) {
                        callLogBean.setName(number);
                    }
                    callLogBean.setType(type);
                    callLogBean.setDate(sfd.format(date));

                    callLogs.add(callLogBean);
                }
                if (callLogs.size() > 0) {
                    setAdapter(callLogs);
                }
            }
            super.onQueryComplete(token, cookie, cursor);
        }
    }

    private void setAdapter(List<CallLogBean> callLogs) {
        adapter = new DialAdapter(getActivity(), callLogs);
        callLogListView.setAdapter(adapter);
    }
}


