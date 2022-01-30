package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        创建消息版对象
        Notification.Builder builder = new Notification.Builder(MainActivity.this);
//        设置通知的图标
        builder.setSmallIcon(R.mipmap.ic_launcher);
//        设置通知内容
        builder.setContentText("您好，这是一个消息版测试程序");
//        设置通知时间
        builder.setWhen(System.currentTimeMillis());
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        通过builder.build() 方法生成 Notification对象 并发送通知 id=1
        manager.notify(1, builder.build());

    }
}