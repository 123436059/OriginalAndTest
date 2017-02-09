package com.originalandtest.tx.originalandtest.shootPlane.original.entity;

import android.content.Context;

import com.originalandtest.tx.originalandtest.R;

public class Hero extends BaseEntity {


    public Hero(Context context) {
        super(context);
    }

    @Override
    protected int getImageRes() {
        return R.drawable.hero1;
    }

}
