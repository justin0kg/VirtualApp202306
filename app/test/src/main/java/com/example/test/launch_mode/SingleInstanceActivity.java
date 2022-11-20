package com.example.test.launch_mode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingleInstanceActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getClass().getSimpleName());
        LinearLayout layout = new LinearLayout(this);
        Button button = new Button(this);
        button.setText("StartActivity");
        button.setOnClickListener(this);
        layout.addView(button);

        TextView textView = new TextView(this);
        textView.setText("taskId: " + getTaskId());
        layout.addView(textView);

        setContentView(layout);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, StandardActivity.class);
        startActivity(intent);
    }
}
