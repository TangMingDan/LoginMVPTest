package com.example.administrator.loginmvptest3.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.loginmvptest3.R;
import com.example.administrator.loginmvptest3.model.User;
import com.example.administrator.loginmvptest3.presenter.ILoginPresenter;
import com.example.administrator.loginmvptest3.presenter.ILoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener {
    private Button mLogin;
    private EditText mInputNUm;
    private EditText mInputPass;
    private Toolbar toolbar;
    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        loginPresenter = new ILoginPresenterCompl(this);
        mLogin = findViewById(R.id.btn_loginactivity_login);
        mInputNUm = findViewById(R.id.edit_username);
        mInputPass = findViewById(R.id.edit_password);
        mLogin.setOnClickListener(this);
        toolbar = findViewById(R.id.toolbar_login);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.back();
            }
        });
    }


    @Override
    public void onClick(View v) {
        String num = mInputNUm.getText().toString();
        String pass = mInputPass.getText().toString();
        switch (v.getId()){
            case R.id.btn_loginactivity_login:
                loginPresenter.doLogin(num,pass);
                break;

        }
    }

    @Override
    public void onLoginResult(Boolean result, String msg) {
        if(result){
            Intent intent = new Intent(LoginActivity.this,UserActivity.class);
            startActivity(intent);
        }
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void back() {
        finish();
    }
}
