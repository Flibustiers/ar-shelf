package com.vuforia.engine.native_sample;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


 class ARactivty extends AppCompatActivity {
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView = new WebView(getApplicationContext());
        setContentView(webView);
        webView.loadUrl("https://daniltech.github.io/");
        WebSettings MyWebviewSettings =  webView.getSettings();
        MyWebviewSettings.setAllowFileAccessFromFileURLs(true);
        MyWebviewSettings.setAllowUniversalAccessFromFileURLs(true);
        MyWebviewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        MyWebviewSettings.setJavaScriptEnabled(true);
        MyWebviewSettings.setDomStorageEnabled(true);
        MyWebviewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        MyWebviewSettings.setBuiltInZoomControls(true);
        MyWebviewSettings.setAllowFileAccess(true);
        MyWebviewSettings.setSupportZoom(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    request.grant(request.getResources());
                }
            }

        });
    }
}