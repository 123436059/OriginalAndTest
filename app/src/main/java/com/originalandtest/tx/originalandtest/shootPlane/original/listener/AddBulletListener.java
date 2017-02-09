package com.originalandtest.tx.originalandtest.shootPlane.original.listener;

import com.originalandtest.tx.originalandtest.shootPlane.original.entity.Bullet;
import com.originalandtest.tx.originalandtest.shootPlane.original.entity.Hero;
import com.originalandtest.tx.originalandtest.shootPlane.original.listener.AddEntityListener;
import com.utill.tx.txlibrary.Log.L;

public class AddBulletListener extends AddEntityListener<Bullet> {

    public AddBulletListener(Bullet t) {
        super(t);
    }

    @Override
    protected void onLayoutFinish() {
        Bullet bullet = t;

        //初始化子弹的位置
        Hero hero = bullet.getHero();
        bullet.setTranslationX(hero.getTranslationX() + hero.getWidth() / 2);
        bullet.setTranslationY(hero.getTranslationY() - bullet.getHeight());
//		Log.e("tag", "x : "+bullet.getTranslationX() +"  y:"+bullet.getTranslationY());
        //子弹开始射击
        float targetY = -bullet.getHeight();
        float distance = targetY - bullet.getTranslationY();
        long duration = (long) (Math.abs(distance) * 3);
        bullet.shot(targetY, duration);
    }

}
