package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int check_id[] = {R.id.ck1, R.id.ck2, R.id.ck3, R.id.ck4, R.id.ck5, R.id.ck6, R.id.ck7, R.id.ck8, R.id.ck9};
    TextView tvFood;
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFood = findViewById(R.id.tvFood);
        btnBuy = findViewById(R.id.btnBuy);

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "";
                for (int id : check_id) {
                    CheckBox chk = findViewById(id);
                    if (chk.isChecked()) {
                        msg += chk.getText() + "   X 1 " + "\n";
                    }
                }
                tvFood.setText(msg);
            }
        });

    }
}