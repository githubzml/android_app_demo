package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bDD = findViewById(R.id.bDD);

        bDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                定义对话框对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                定制对话框的标题和属性
                builder.setTitle("对话框");
                builder.setMessage("对话框小DEMO，请操作");
//                添加确认按钮
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "单击了确认按钮", Toast.LENGTH_LONG).show();
                    }
                });
//                添加取消按钮
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "单击了取消按钮", Toast.LENGTH_LONG).show();

                    }
                });
//                创建对话框
                builder.create();
//                显示对话框
                builder.show();
            }
        });
    }
}