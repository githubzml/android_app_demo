package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {
    //    定义存放页面的数组
    ArrayList<View> viewList = new ArrayList<>();
    //    保存图片文件Id数组
    int[] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    //    定义保存图片的说明字符串数组
    String[] details = {"立春", "雨水", "惊蛰", "春分"};

    int[] infoarray = {R.string.lichun, R.string.yushui, R.string.jingzhe, R.string.chunfen};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
//        接受id 用于显示详情和评论
        Intent intent = getIntent();
        int i = intent.getIntExtra("position", 0);
//        准备数据
        LayoutInflater lf = getLayoutInflater().from(ProductDetailActivity.this);

        View view = lf.inflate(R.layout.layoutdetail, null);
//        根据Id在的详情页显示指定产品的信息
        TextView tvDetail = view.findViewById(R.id.tvDetail);
        tvDetail.setText(details[i]);
//        图片
        ImageView imgproduct = view.findViewById(R.id.imgProduct);
        imgproduct.setImageResource(images[i]);
//        详情
        TextView text2 = view.findViewById(R.id.text2);
        text2.setText(infoarray[i]);
//        添加文本滚动
        text2.setMovementMethod(ScrollingMovementMethod.getInstance());

        viewList.add(view);

        view = lf.inflate(R.layout.layoutcontact, null);
        TextView tvProductContact = view.findViewById(R.id.tvProductContact);

        tvProductContact.setText("以下是" + details[i] + "适合吃的食物 略去...");

        viewList.add(view);
//        基于准备好的数据创建PagerAdapter 适配器对象
        PagerAdapter adapter = new PagerAdapter() {
            //            返回页面个数
            @Override
            public int getCount() {
                return viewList.size();
            }

            //            判断是否是同一个页面
            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            //            页面初始化
            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            //            销毁页面
            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                super.destroyItem(container, position, object);
                container.removeView(viewList.get(position));
            }
        };
//        把适配器加载到ViewPager中
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
    }
}