package com.example.chen.phone;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareDialog extends PopupWindow {

    private AlertDialog dialog;
    private GridView gridView;
    private Button cancelButton;
    private SimpleAdapter saImageItems;
    private int[] image = {R.mipmap.sns_sina_icon, R.mipmap.sns_weixin_icon, R.mipmap.sns_weixin_timeline_icon, R.mipmap.sns_qqfriends_icon, R.mipmap.sns_qzone_icon, R.mipmap.short_message_nor};
    private String[] name = {"微博", "微信", "朋友圈", "QQ", "空间", "短信"};

    public ShareDialog(Context context) {
/*
        View view = LayoutInflater.from(context).inflate(R.layout.share_dialog,null);
*/

        dialog = new AlertDialog.Builder(context).create();
        dialog.show();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER_VERTICAL); // 非常重要：设置对话框弹出的位置
        window.setContentView(R.layout.share_dialog);

        gridView = (GridView) window.findViewById(R.id.share_gridView);
        cancelButton = (Button) window.findViewById(R.id.share_cancel);
        List<HashMap<String, Object>> shareList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < image.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", image[i]);//添加图像资源的ID
            map.put("ItemText", name[i]);//按序号做ItemText
            shareList.add(map);
        }

        saImageItems = new SimpleAdapter(context, shareList, R.layout.share_item, new String[]{"ItemImage", "ItemText"}, new int[]{R.id.imageView1, R.id.textView1});
        gridView.setAdapter(saImageItems);
    }


    public void setCancelButtonOnClickListener(OnClickListener Listener) {
        cancelButton.setOnClickListener(Listener);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        gridView.setOnItemClickListener(listener);
    }


    /**
     * 关闭对话框
     */
    public void dismiss() {
        dialog.dismiss();
    }
}