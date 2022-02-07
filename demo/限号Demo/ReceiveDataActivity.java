package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReceiveDataActivity extends AppCompatActivity {
    String TAG = "标记";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        Button findA = findViewById(R.id.findA);

//        星期一	星期二	星期三	星期四	星期五
//        4 和 9	5 和 0	1 和 6	2 和 7	3 和 8


        findA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edInput = findViewById(R.id.edInput);

                TextView ccc = findViewById(R.id.ccc);

                String aa = edInput.getText().toString();

                switch (aa) {
                    case "1":
                    case "一":
                        ccc.setText("星期一是 4 和 9");
                        break;
                    case "2":
                    case "二":
                        ccc.setText("星期二是 5 和 0");
                        break;
                    case "3":
                    case "三":
                        ccc.setText("星期三是 1 和 6");
                        break;
                    case "4":
                    case "四":
                        ccc.setText("星期四是 2 和 7");
                        break;
                    case "5":
                    case "五":
                        ccc.setText("星期五是 3 和 8");
                        break;
                    default:
                        ccc.setText("查询有误,请重新输入");
                }


            }
        });
//        跳转
        Button tZHq = findViewById(R.id.tZHq);
        tZHq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReceiveDataActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}