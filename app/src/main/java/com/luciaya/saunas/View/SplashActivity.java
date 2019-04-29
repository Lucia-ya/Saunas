package com.luciaya.saunas.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.luciaya.saunas.R;

/**
 *  Splash - ScreenВыводится темой - бэкграунд картинка пока приложение грузится
 */

public class SplashActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGHT = 1500; //количество милисекунд в таймере
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mImageView = (ImageView) findViewById(R.id.progressBar);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_center);
        animation.setRepeatMode(Animation.INFINITE);
        mImageView.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() { //таймер
                Intent intent = new Intent(SplashActivity.this, SelectCityActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
