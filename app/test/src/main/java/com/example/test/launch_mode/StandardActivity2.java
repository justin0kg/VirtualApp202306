package com.example.test.launch_mode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StandardActivity2 extends Activity {

    public static int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getClass().getSimpleName());

        LinearLayout layout = new LinearLayout(this);

        TextView textView = new TextView(this);
        textView.setText("taskId: " + getTaskId() + " this@" + counter++);
        layout.addView(textView);

        setContentView(layout);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.e("TTTTTTTT", "onNewIntent: " + intent);
        Toast.makeText(this, "onNewIntent: " + intent, Toast.LENGTH_SHORT).show();
    }
}
