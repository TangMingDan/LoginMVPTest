package com.example.administrator.loginmvptest3.view;

import com.example.administrator.loginmvptest3.Util.Animators;
import com.example.administrator.loginmvptest3.adapter.MessageAdapter;
import com.example.administrator.loginmvptest3.model.Message;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.administrator.loginmvptest3.R;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements View.OnTouchListener{
    private ListView listView;
    private Toolbar toolbar;
    private int mTouchSlop;  // 最低滑动距离，超过即为滑动状态
    private float mFirstY;  //点击时的Y
    private float mCurrentY; // 滑动时的Y
    private int direction; // 滑动方向
//    private ObjectAnimator mAnimator;
    private List<Message> messageList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        init();
    }

    private void init() {
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop(); //设置最低滑动距离
        listView = findViewById(R.id.friends_list);
        toolbar = findViewById(R.id.toolbar_friends);
        View header = new View(this);
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(
                        R.dimen.abc_action_bar_default_height_material)));
        listView.addHeaderView(header);
        initMessage();
        MessageAdapter adapter = new MessageAdapter
                (UserActivity.this,R.layout.list_item,messageList);
        listView.setAdapter(adapter);
        listView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mCurrentY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mFirstY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if(mCurrentY - mFirstY > mTouchSlop){
                    direction = 0; //down
                }else if(mFirstY - mCurrentY > mTouchSlop){
                    direction = 1; //up
                }
                if(direction == 0){
                    Animators.toolbarAnim(0,toolbar);
//                    toolbarAnim(0);   // hide
                }
                if(direction == 1){
                    Animators.toolbarAnim(1,toolbar);
//                    toolbarAnim(1);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
    public void initMessage(){
        for (int i = 0; i < 40; i++) {
            Message message = new Message("重邮老乡群",R.drawable.touxiang,"老哥们，出来玩啊","15.01");
            messageList.add(message);
        }
    }
//    private void toolbarAnim(int flag) {
//        if(mAnimator != null && mAnimator.isRunning()){
//            mAnimator.cancel();
//        }
//        if(flag == 0){
//            mAnimator = ObjectAnimator.ofFloat
//                    (toolbar,"translationY",toolbar.getTranslationY(),0);
//        }else {
//            mAnimator = ObjectAnimator.ofFloat
//                    (toolbar,"translationY",toolbar.getTranslationY(),-toolbar.getHeight());
//        }
//        mAnimator.start();
//    }
}
