package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    int num = 0;
    //    图片id的数组
    int img_id[] = {R.drawable.newyear1, R.drawable.newyear2, R.drawable.newyear3, R.drawable.newyear4, R.drawable.newyear5};
    //    记录图片在数组中的索引
    int position = 0;
    ImageView bigimage;
    float x0 = 0, x1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bigimage = this.findViewById(R.id.bigImage);
//        允许单击 获取鼠标位置
        bigimage.setClickable(true);
//        将图片加载到img控件显示
        bigimage.setImageResource(img_id[position]);
//        设置滑动
        bigimage.setOnTouchListener(this);


    }

    //    控件触摸事件
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x0 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x1 = event.getX();
                float w;
                w = x1 - x0;
                if (w > 0)
                    viewPrePhoto();
                if (-w > 0)
                    viewNextPhoto();
                break;
        }
        return false;
    }

    private void viewNextPhoto() {
//        如果已经加载到队尾
        if (position == img_id.length - 1) {
            Toast.makeText(this, "已经是最后一张了！", Toast.LENGTH_LONG).show();
        } else {
//            指针下移 显示下一张图片
            position = position + 1;
            bigimage.setImageResource(img_id[position]);
        }
    }

    private void viewPrePhoto() {
        if (position == 0) {
            Toast.makeText(this, "已经是第一张图片了！", Toast.LENGTH_LONG).show();
        } else {
            position = position - 1;
            bigimage.setImageResource(img_id[position]);
        }
    }

}
