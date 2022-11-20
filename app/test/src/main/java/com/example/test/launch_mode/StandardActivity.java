package com.example.test.launch_mode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StandardActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getClass().getSimpleName());

        LinearLayout layout = new LinearLayout(this);

        Button button = new Button(this);
        button.setText("Launch special case");
        button.setOnClickListener(this);
        layout.addView(button);

        TextView textView = new TextView(this);
        textView.setText("taskId: " + getTaskId() + "  " + this);
        layout.addView(textView);

        setContentView(layout);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.e("TTTTTTTT", "onNewIntent: " + intent);
        Toast.makeText(this, "onNewIntent: " + intent, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, StandardActivity2.class);
        startActivity(intent);
    }
}
