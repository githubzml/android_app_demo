package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {
    Button btnCom;
    EditText etWeight, etLight;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);
//        获取操作节点
        etWeight = findViewById(R.id.etWeight);
        etLight = findViewById(R.id.etLight);

        btnCom = findViewById(R.id.btnCom);
        info = findViewById(R.id.info);
//        绑定查询事件
        btnCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "";
                int a = Integer.parseInt(etWeight.getText().toString());
                double b = Double.parseDouble(etLight.getText().toString());
                double c = a / (b * b);
                double m = Double.parseDouble(String.format("%.1f", c));

                if (m < 18.5) {
                    str = "过轻";
                } else if (18.5 <= m && m < 20) {
                    str = "标准";
                } else if (20 <= m && m < 25) {
                    str = "适中";
                } else if (25 <= m && m < 30) {
                    str = "过重";
                } else if (30 <= m && m < 35) {
                    str = "肥胖";
                } else if (m >= 35) {
                    str = "非常肥胖";
                }
                info.setText("您的BMI数值是：" + m + " 您的健康状态是：" + str);
            }
        });
    }
}