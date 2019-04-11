package com.example.administrator.loginmvptest3.presenter;

import com.example.administrator.loginmvptest3.model.User;
import com.example.administrator.loginmvptest3.view.ILoginView;

public class ILoginPresenterCompl implements ILoginPresenter{
    private ILoginView loginView;
    User user;

    public ILoginPresenterCompl(ILoginView loginView) {
        this.loginView = loginView;
        user = new User("9288","65598");
    }

    @Override
    public void doLogin(String usernum, String userPass) {
        boolean result = false;
        String msg;
        if(user.getUsernum().equals(usernum) && user.getUserPass().equals(userPass)){
            result = true;
            msg = "登陆成功";
        }else {
            msg = "帐号或者密码错误";
        }
        loginView.onLoginResult(result,msg);
    }

    @Override
    public void back() {
        loginView.back();
    }

//    @Override
//    public void doRegistered(String inputNum, String inputPass) {
//
//    }
}
