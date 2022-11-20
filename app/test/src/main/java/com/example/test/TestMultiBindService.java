package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import androidx.annotation.Nullable;

public class TestMultiBindService extends Service {

    private static final String TAG = TestMultiBindService.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: " + intent);
        return new Messenger(new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Log.e("TTTTT", "handle msg: " + msg.what);
                super.handleMessage(msg);
            }
        }).getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: " + intent);
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "onRebind: " + intent);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
    }
}
