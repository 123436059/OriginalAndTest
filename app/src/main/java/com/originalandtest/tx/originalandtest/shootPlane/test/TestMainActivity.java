package com.originalandtest.tx.originalandtest.shootPlane.test;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.originalandtest.tx.originalandtest.R;
import com.originalandtest.tx.originalandtest.shootPlane.original.entity.Bullet;
import com.originalandtest.tx.originalandtest.shootPlane.original.entity.Hero;
import com.originalandtest.tx.originalandtest.shootPlane.original.listener.AddBulletListener;
import com.originalandtest.tx.originalandtest.shootPlane.original.listener.AddHeroListener;

public class TestMainActivity extends AppCompatActivity {

    private boolean isGameOn = true;

    private static final int BULLET_INTERVAL = 100;


    private static final int MSG_BULLET = 0x01;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //TODO cancel test
            switch (msg.what) {
                case MSG_BULLET:
                    if (isGameOn) {
                        generateBullet();
                    }
                    break;
            }

        }
    };
    private ViewGroup mContentView;
    private Hero mHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        mContentView = (ViewGroup) findViewById(R.id.activity_test_main);
        findViewById(R.id.btnShoot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateHero();
                generateBullet();
            }
        });
    }

    private void generateHero() {
        mHero = new Hero(this);
        mHero.getViewTreeObserver().addOnGlobalLayoutListener(new AddHeroListener(mHero));
        mHero.setVisibility(View.VISIBLE);
        mContentView.addView(mHero);
    }

    private void generateBullet() {
        Bullet bullet = new Bullet(this);
        bullet.getViewTreeObserver().addOnGlobalLayoutListener(new AddBulletListener(bullet));
        bullet.setHero(mHero);
        mContentView.addView(bullet);
        mHandler.sendEmptyMessageDelayed(MSG_BULLET, BULLET_INTERVAL);
    }
}
