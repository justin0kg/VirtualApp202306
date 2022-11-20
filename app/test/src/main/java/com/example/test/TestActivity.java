package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.test.forward_result.PreActivity;

public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int checkPermission = getPackageManager().checkPermission("android.permission.INTERNET", getPackageName());
        Log.e("VA", "check android.permission.INTERNET in : " + getPackageManager());
        Log.e("VA", ">>>> checkPermission : " + checkPermission + ",  is " + (checkPermission == PackageManager.PERMISSION_GRANTED));


        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, PreActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }

    public void startDownload(View v) {
        long id = new DownloadManagerUtil(this)
                .download("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png", "baidu", "baidu");
        Toast.makeText(this, "start download:" + id, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Toast.makeText(this, "onNewIntent: " + intent, Toast.LENGTH_SHORT).show();
    }
}