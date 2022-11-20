package com.example.test.forward_result;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class PreActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        Button button = new Button(this);
        button.setText("PreActivity start AActivity");
        button.setOnClickListener(this);
        layout.addView(button);
        setContentView(layout);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AActivity.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("TTTTTTTTTT", "onActivityResult: " + resultCode + " data: " + data);
    }
}
