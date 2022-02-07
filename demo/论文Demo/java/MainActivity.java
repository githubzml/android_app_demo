package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //         存放数据的变量
    List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
    //        保存图片文件Id数组
    int[] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    //        定义保存图片的说明字符串
    String[] names = {"立春", "雨水", "惊蛰", "春分"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        页面1-产品列表展示
        int n = 4;
        for (int i = 0; i < n; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", images[i]);
            map.put("name", names[i]);
            datas.add(map);
        }
//        键名和显示控件名对应数组
        String[] from = {"image", "name"};
        int[] to = {R.id.image1, R.id.text1};

        ListView listView = findViewById(R.id.listView_);
//        创建适配器对象
        SimpleAdapter adapter = new SimpleAdapter(this, datas, R.layout.list_item, from, to);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

        Button limitNumberFind = findViewById(R.id.limitNumberFind);
        Button BMIFind = findViewById(R.id.BMIFind);
//        页面2-BMI跳转
        BMIFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                startActivity(intent);
            }
        });
//        页面3-限号跳转
        limitNumberFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReceiveDataActivity.class);
                startActivity(intent);
            }
        });
    }
}
