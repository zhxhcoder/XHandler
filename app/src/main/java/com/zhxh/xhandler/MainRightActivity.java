package com.zhxh.xhandler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zhxh.xhandler.simulation.MainActivity;

import java.lang.ref.WeakReference;

/**
 * Created by zhxh on 2018/4/19.
 */

public class MainRightActivity extends AppCompatActivity {

    //容易造成内存泄漏的写法：
    //private Handler mHandler = new Handler() {
    //    @Override
    //    public void handleMessage(Message msg) {
    //        //...
    //    }
    //};

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_main);
    //    loadData();
    //}

    //private void loadData() {
    //    //...request
    //    Message message = Message.obtain();
    //    mHandler.sendMessage(message);
    //}

    //static class TestResource {
    //    private static final String TAG = "";
    //    //...
    //}

    //修复内存泄漏的方法：
    private MyHandler mHandler = new MyHandler(this);
    private TextView mTextView;
    private Button simulator;

    private static class MyHandler extends Handler {
        private WeakReference<Context> reference;

        public MyHandler(Context context) {
            reference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            MainRightActivity activity = (MainRightActivity) reference.get();
            if (activity != null) {
                activity.mTextView.setText("XHandler");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_right);

        mTextView = findViewById(R.id.mTextView);
        simulator = findViewById(R.id.simulator);

        simulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainRightActivity.this, MainActivity.class));
            }
        });

        loadData();
    }

    private void loadData() {
        Message message = Message.obtain();
        mHandler.sendMessage(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}

