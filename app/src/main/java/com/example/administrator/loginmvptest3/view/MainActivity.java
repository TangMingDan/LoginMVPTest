package com.example.administrator.loginmvptest3.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.loginmvptest3.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mLogin;
    private Button mRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mLogin = findViewById(R.id.btn_mainactivity_login);
        mRegistered = findViewById(R.id.btn_registered);
        mLogin.setOnClickListener(this);
        mRegistered.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_mainactivity_login:
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_registered:
                Intent intent1 = new Intent(MainActivity.this,registeredActivity.class);
                startActivity(intent1);
        }
    }
}
