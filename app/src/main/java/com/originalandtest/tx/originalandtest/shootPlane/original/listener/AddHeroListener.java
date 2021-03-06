package com.originalandtest.tx.originalandtest.shootPlane.original.listener;

import android.view.View;
import android.view.ViewGroup;

import com.originalandtest.tx.originalandtest.shootPlane.original.entity.Hero;
import com.utill.tx.txlibrary.Log.L;


public class AddHeroListener extends AddEntityListener<Hero>{

    public AddHeroListener(Hero t) {
        super(t);
    }

    @Override
    protected void onLayoutFinish() {
        Hero hero = t;

        //将heao设置到底部中心
        int parentWidth = ((ViewGroup)hero.getParent()).getWidth();
        int parentHeitht = ((ViewGroup)hero.getParent()).getHeight();
        float translationX = parentWidth/2 - hero.getWidth()/2;
        hero.setTranslationX(translationX);
        hero.setTranslationY(parentHeitht-hero.getHeight());
        L.d("设置 hero center test");
        hero.setVisibility(View.VISIBLE);
    }

}
