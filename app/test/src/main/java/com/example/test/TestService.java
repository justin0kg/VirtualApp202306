package com.example.test;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * @author Lody
 */
public class TestService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TTTTT", "onStartCommand : " + intent + ", startId : " + startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TTTTT", "onBind : " + intent);
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
        Log.e("TTTTT", "onUnbind : " + intent);
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e("TTTTT", "onRebind : " + intent);
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TTTTT", "onDestroy");
    }
}
