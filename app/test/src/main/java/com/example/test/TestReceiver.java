package com.example.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * @author Lody
 */
public class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "rec: " + intent, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "rec: " + intent, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "rec: " + intent, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "rec: " + intent, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "rec: " + intent, Toast.LENGTH_SHORT).show();
        Toast.makeText(context, "rec: " + intent, Toast.LENGTH_SHORT).show();
        Log.e("TTTTTTTT", "rec: " + intent);
    }
}
