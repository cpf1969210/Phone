package com.example.chen.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chen.phone.FragmentMe_feedback;
import com.example.chen.phone.FragmentMe_login;
import com.example.chen.phone.FragmentMe_member;
import com.example.chen.phone.FragmentMe_orderquery;
import com.example.chen.phone.FragmentMe_recharge;
import com.example.chen.phone.R;
import com.example.chen.phone.ShareDialog;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.system.text.ShortMessage;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;

/**
 * 个人主界面
 * @author chen
 * 2016/2/26
 */
public class FragmentMe extends Fragment implements PlatformActionListener{
    ShareDialog shareDialog;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // TODO Auto-generated method stub

         View view=inflater.inflate(R.layout.fragement_me, container, false);

        //1、分享的初始化
        ShareSDK.initSDK(getActivity());
        //实例化
        //登录
        ImageView login=(ImageView)view.findViewById(R.id.admin_login);
        TextView text_login=(TextView)view.findViewById(R.id.text_login);
        //意见反馈
        RelativeLayout feedback=(RelativeLayout)view.findViewById(R.id.feedback);
        //分享
        ImageView  sharebutton=(ImageView)view.findViewById(R.id.shareButton);
        TextView text_share=(TextView)view.findViewById(R.id.text_shareButton);
        //话单查询
        ImageView orderquery=(ImageView)view.findViewById(R.id.orderquery);
        TextView text_orderquery=(TextView)view.findViewById(R.id.text_orderquery);
        //充值卡充值
        TextView text_recharge= (TextView)view.findViewById(R.id.textrecharge);
        ImageView image_recharge=(ImageView)view.findViewById(R.id.recharge);
        //开通会员
        ImageView vip=(ImageView)view.findViewById(R.id.vip);
        TextView text_vip=(TextView)view.findViewById(R.id.text_vip);
        ImageView alogo_ownership=(ImageView)view.findViewById(R.id.alogo_ownership);

        //加入监听
        alogo_ownership.setOnClickListener(listener);
        vip.setOnClickListener(listener);
        text_vip.setOnClickListener(listener);
        orderquery.setOnClickListener(listener);
        text_orderquery.setOnClickListener(listener);
        sharebutton.setOnClickListener(listener);
        text_share.setOnClickListener(listener);
        feedback.setOnClickListener(listener);
        login.setOnClickListener(listener);
        text_login.setOnClickListener(listener);
        text_recharge.setOnClickListener(listener);
        image_recharge.setOnClickListener(listener);
        return view;

    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //管理员登录
                case R.id.admin_login:
                    Intent intent=new Intent();
                    intent.setClass(getActivity(),FragmentMe_login.class);
                    startActivity(intent);
                    break;
                //管理员登录
                case R.id.text_login:
                    Intent intent1=new Intent();
                    intent1.setClass(getActivity(),FragmentMe_login.class);
                    startActivity(intent1);
                    break;
                //意见反馈
                case R.id.feedback:
                    Intent intent2=new Intent();
                    intent2.setClass(getActivity(),FragmentMe_feedback.class);
                    startActivity(intent2);
                    break;
                //分享
                case R.id.shareButton:
                    shareDialog = new ShareDialog(getActivity());
                    shareDialog.setCancelButtonOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            shareDialog.dismiss();

                        }
                    });
                    shareDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1,
                                                int arg2, long arg3) {
                            HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);
                            if (item.get("ItemText").equals("微博")) {

                                //设置分享内容
                                ShareParams sp = new ShareParams();
                               /* sp.setText("我是分享文本，啦啦啦~http://uestcbmi.com/"); //分享文本
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul*/
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情
                                //非常重要：获取平台对象
                                Platform sinaWeibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                                sinaWeibo.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                sinaWeibo.share(sp);

                            } else if (item.get("ItemText").equals("微信")) {

                                //设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setShareType(Platform.SHARE_WEBPAGE);//非常重要：一定要设置分享属性
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情

                                //非常重要：获取平台对象
                                Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
                                wechat.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                wechat.share(sp);


                            } else if (item.get("ItemText").equals("朋友圈")) {
                                //设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setShareType(Platform.SHARE_WEBPAGE); //非常重要：一定要设置分享属性
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情

                                //非常重要：获取平台对象
                                Platform wechatMoments = ShareSDK.getPlatform(WechatMoments.NAME);
                                wechatMoments.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                wechatMoments.share(sp);

                            } else if (item.get("ItemText").equals("QQ")) {
                                //设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情
                                //非常重要：获取平台对象
                                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                                qq.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                qq.share(sp);
                            }else if (item.get("ItemText").equals("空间")){
                                //设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情
                                //非常重要：获取平台对象
                                Platform qq = ShareSDK.getPlatform(QZone.NAME);
                                qq.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                qq.share(sp);
                            }else if (item.get("ItemText").equals("短信")){
                                //设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
/*
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
*/
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情
                                //非常重要：获取平台对象
                                Platform circle = ShareSDK.getPlatform(ShortMessage.NAME);
                                circle.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                circle.share(sp);

                            }


                            shareDialog.dismiss();

                        }
                    });

                    break;
                case  R.id.text_shareButton:
                    shareDialog = new ShareDialog(getActivity());
                    shareDialog.setCancelButtonOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            shareDialog.dismiss();

                        }
                    });
                    shareDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1,
                                                int arg2, long arg3) {
                            HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);
                            if (item.get("ItemText").equals("微博")) {

                                //2、设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情
                                //3、非常重要：获取平台对象
                                Platform sinaWeibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                                sinaWeibo.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                sinaWeibo.share(sp);

                            } else if (item.get("ItemText").equals("微信好友")) {
                                Toast.makeText(getActivity(), "您点中了" + item.get("ItemText"), Toast.LENGTH_LONG).show();

                                //2、设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setShareType(Platform.SHARE_WEBPAGE);//非常重要：一定要设置分享属性
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情
                                //3、非常重要：获取平台对象
                                Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
                                wechat.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                wechat.share(sp);


                            } else if (item.get("ItemText").equals("朋友圈")) {
                                //2、设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setShareType(Platform.SHARE_WEBPAGE); //非常重要：一定要设置分享属性
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情

                                //3、非常重要：获取平台对象
                                Platform wechatMoments = ShareSDK.getPlatform(WechatMoments.NAME);
                                wechatMoments.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                wechatMoments.share(sp);

                            } else if (item.get("ItemText").equals("QQ")) {
                                //2、设置分享内容
                                ShareParams sp = new ShareParams();
                                sp.setTitle("网之翼科技有限公司");
                                sp.setText("网之翼商城，最贴心最便捷最具潜力的微商城");
                                sp.setImageUrl("http://7sby7r.com1.z0.glb.clouddn.com/CYSJ_02.jpg");//网络图片rul
                                sp.setTitleUrl("http://www.sdwangzhiyi.com");  //网友点进链接后，可以看到分享的详情
                                //3、非常重要：获取平台对象
                                Platform qq = ShareSDK.getPlatform(QQ.NAME);
                                qq.setPlatformActionListener(FragmentMe.this); // 设置分享事件回调
                                // 执行分享
                                qq.share(sp);

                            }


                            shareDialog.dismiss();

                        }
                    });

                    break;
                //话单查询
                case R.id.orderquery:
                    Intent intent3=new Intent();
                    intent3.setClass(getActivity(), FragmentMe_orderquery.class);
                    startActivity(intent3);
                    break;
                //话单查询
                case R.id.text_orderquery:
                    Intent intent4=new Intent();
                    intent4.setClass(getActivity(),FragmentMe_orderquery.class);
                    startActivity(intent4);
                    break;
                //充值卡充值
                case R.id.recharge:
                    Intent intent5=new Intent();
                    intent5.setClass(getActivity(),FragmentMe_recharge.class);
                    startActivity(intent5);
                    break;
                //充值卡充值
                case R.id.textrecharge:
                    Intent intent6=new Intent();
                    intent6.setClass(getActivity(),FragmentMe_recharge.class);
                    startActivity(intent6);
                    break;
                //开通会员
                case R.id.vip:
                    Intent intent7=new Intent();
                    intent7.setClass(getActivity(),FragmentMe_member.class);
                    startActivity(intent7);
                    break;
                //开通会员
                case R.id.text_vip:
                    Intent intent8=new Intent();
                    intent8.setClass(getActivity(),FragmentMe_member.class);
                    startActivity(intent8);
                    break;
                case R.id.alogo_ownership:

                    new AlertDialog.Builder(getActivity())
                            .setTitle("设置区号")
                            .setView(new EditText(getActivity()))
                            .setPositiveButton("确定", null)
                            .setNegativeButton("取消", null)
                            .show();
                    break;
            }
        }
    };
    @Override
    public void onCancel(Platform arg0, int arg1) {//回调的地方是子线程，进行UI操作要用handle处理
        handler.sendEmptyMessage(5);

    }
    @Override
    public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {//回调的地方是子线程，进行UI操作要用handle处理
        if (arg0.getName().equals(SinaWeibo.NAME)) {// 判断成功的平台是不是新浪微博
            handler.sendEmptyMessage(1);
        } else if (arg0.getName().equals(Wechat.NAME)) {
            handler.sendEmptyMessage(1);
        } else if (arg0.getName().equals(WechatMoments.NAME)) {
            handler.sendEmptyMessage(3);
        } else if (arg0.getName().equals(QQ.NAME)) {
            handler.sendEmptyMessage(4);
        }

    }

    @Override
    public void onError(Platform arg0, int arg1, Throwable arg2) {//回调的地方是子线程，进行UI操作要用handle处理
        arg2.printStackTrace();
        Message msg = new Message();
        msg.what = 6;
        msg.obj = arg2.getMessage();
        handler.sendMessage(msg);
    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Toast.makeText(getActivity(), "微博分享成功", Toast.LENGTH_LONG).show();
                    break;

                case 2:
                    Toast.makeText(getActivity(), "微信分享成功", Toast.LENGTH_LONG).show();
                    break;
                case 3:
                    Toast.makeText(getActivity(), "朋友圈分享成功", Toast.LENGTH_LONG).show();
                    break;
                case 4:
                    Toast.makeText(getActivity(), "QQ分享成功", Toast.LENGTH_LONG).show();
                    break;

                case 5:
                    Toast.makeText(getActivity(), "取消分享", Toast.LENGTH_LONG).show();
                    break;
                case 6:
                    Toast.makeText(getActivity(), "分享失败啊" + msg.obj, Toast.LENGTH_LONG).show();
                    break;

                default:
                    break;
            }
        }

    };

}
