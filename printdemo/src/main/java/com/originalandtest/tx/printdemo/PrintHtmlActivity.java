package com.originalandtest.tx.printdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.print.PrintManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.originalandtest.tx.printdemo.R;


/**
 * 打印Html页面
 *
 * @author ldm
 * @description：
 * @date 2016-4-28 上午9:28:25
 */
public class PrintHtmlActivity extends Activity {

    private WebView mWebView;

    private boolean mDataLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_html);
        mWebView = (WebView) findViewById(R.id.web_view);

        findViewById(R.id.btnPrintHtml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                print();
            }
        });

        // 重要：只有在加载页面后才能启用打印选项。
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // 加载完成，显示打印选项。
                mDataLoaded = true;
                invalidateOptionsMenu();
            }
        });
        // 加载本地Html文件
        mWebView.loadUrl("http://www.baidu.com");
    }

    @SuppressWarnings("deprecation")
    private void print() {
        PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
        printManager.print("MotoGP stats",
                mWebView.createPrintDocumentAdapter(), null);
    }
}
