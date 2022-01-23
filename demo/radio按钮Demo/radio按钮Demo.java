package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPass;
    TextView tvMessage;
    RadioGroup rpRole;
    String strWelcome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPass = findViewById(R.id.etPass);
        etName = findViewById(R.id.etName);
        tvMessage = findViewById(R.id.tvMessage);

        rpRole = findViewById(R.id.rpRole);
        rpRole.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.rdManage:
                        strWelcome = "欢迎系统管理员:";
                        break;
                    case R.id.rdUser:
                        strWelcome = "欢迎用户:";
                        break;
                }
            }
        });

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (etName.getText().toString().equals("test") && etPass.getText().toString().equals("123"))
            tvMessage.setText(strWelcome + etName.getText());
        else
            tvMessage.setText("用户或者密码错误，请重新输入");
    }
}