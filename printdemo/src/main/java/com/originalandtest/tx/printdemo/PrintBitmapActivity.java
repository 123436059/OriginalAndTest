package com.originalandtest.tx.printdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PrintBitmapActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_bitmap);
        mImageView = (ImageView) findViewById(R.id.ivContent);
        findViewById(R.id.btnPrintPic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPrint();
            }
        });
    }

    private void doPrint() {
        PrintHelper printHelper = new PrintHelper(this);

        /**
         * PrintHelper通过setScaleMode()方法设置模式，现在有两种模式�?
         * SCALE_MODE_FIT：这个打印完整的图片，这样打印纸的边缘可能有空白
         * SCALE_MODE_FILL：这个填满所有的打印纸，因此图片的边缘可能打印不出来
         */
        printHelper.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        // 获取ImageView这个用于显示图片的控件里的图片
        Bitmap bitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();
        // 打印图片
        printHelper.printBitmap("Print Bitmap", bitmap);

    }
}
