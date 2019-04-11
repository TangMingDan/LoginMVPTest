package com.example.administrator.loginmvptest3.Util;

import android.animation.ObjectAnimator;
import android.view.View;

public  class Animators {
    //竖直方向上移动View
    private static ObjectAnimator mAnimator;
    public static void toolbarAnim(int flag, View view) {
        if(mAnimator != null && mAnimator.isRunning()){
            mAnimator.cancel();
        }
        if(flag == 0){
            mAnimator = ObjectAnimator.ofFloat
                    (view,"translationY",view.getTranslationY(),0);
        }else {
            mAnimator = ObjectAnimator.ofFloat
                    (view,"translationY",view.getTranslationY(),-view.getHeight());
        }
        mAnimator.start();
    }
}
