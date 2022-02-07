package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bDD;
    EditText etPhone;

    String TAG = "1111";

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

                LayoutInflater inflater = getLayoutInflater();
                final View aaa = inflater.inflate(R.layout.dialoglayout, null);
//    获取布局文件上的电话号码输入框对象
                etPhone = aaa.findViewById(R.id.etPhone);

                builder.setView(aaa).setTitle("对话框啊")
                        .setMessage("请输入电话号码")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                有问题
                                Log.i(TAG, "onClick: 1");
                                Toast.makeText(MainActivity.this, "您的电话号位为" + etPhone.getText(), Toast.LENGTH_LONG).show();

                            }
                        })

                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
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