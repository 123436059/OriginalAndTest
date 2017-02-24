package com.originalandtest.tx.printdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bitmap_btn)
    Button bitmapBtn;
    @BindView(R.id.layout_btn)
    Button layoutBtn;
    @BindView(R.id.html_btn)
    Button htmlBtn;
    @BindView(R.id.off_screen_btn)
    Button offScreenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bitmap_btn, R.id.layout_btn, R.id.html_btn, R.id.off_screen_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bitmap_btn:
                startActivity(new Intent(this, PrintBitmapActivity.class));
                break;
            case R.id.layout_btn:
                break;
            case R.id.html_btn:
                startActivity(new Intent(this, PrintHtmlActivity.class));
                break;
            case R.id.off_screen_btn:
                break;
        }
    }
}
