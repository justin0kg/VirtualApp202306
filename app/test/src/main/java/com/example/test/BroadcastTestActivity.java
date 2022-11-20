package com.example.test;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.security.SecureRandom;
import java.util.Random;

public class BroadcastTestActivity extends Activity {
    int pid = Process.myPid();
    EditText sendInfo;
    Random random = new SecureRandom();
    TextView recvInfo;

    String action_General;
    String action_Unique;
    String action_VA = "VA_BroadcastTest_io.busniess.va";

    public String getRandStr() {
        return Integer.toString(random.nextInt());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        action_General = "VA_BroadcastTest_" + getPackageName();
        action_Unique = "VA_BroadcastTest_" + getPackageName() + "_" + pid;

        setContentView(R.layout.broadcast_test);
        TextView uidInfo = findViewById(R.id.uid);
        uidInfo.setText("当前App的PID: " + pid);
        sendInfo = findViewById(R.id.send_context);
        sendInfo.setText(getRandStr());

        Button btnRandMsg = findViewById(R.id.btn_rand_msg);
        btnRandMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfo.setText(getRandStr());
            }
        });

        Button btnSendGeneral = findViewById(R.id.btn_send_general);
        btnSendGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(action_General);
                intent.putExtra("pid", pid);
                intent.putExtra("msg", sendInfo.getText());
                intent.putExtra("pkg", getPackageName());
                sendBroadcast(intent);
            }
        });

        Button btnSendUnique = findViewById(R.id.btn_send_unique);
        btnSendUnique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(action_Unique);
                intent.putExtra("pid", pid);
                intent.putExtra("msg", sendInfo.getText());
                intent.putExtra("pkg", getPackageName());
                sendBroadcast(intent);
            }
        });

        Button btnSendVA = findViewById(R.id.btn_send_va);
        btnSendVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(action_VA);
                intent.putExtra("pid", pid);
                intent.putExtra("msg", sendInfo.getText());
                intent.putExtra("pkg", getPackageName());
                sendBroadcast(intent);
            }
        });

        recvInfo = findViewById(R.id.recv);

        IntentFilter filter = new IntentFilter();
        filter.addAction(action_General);
        filter.addAction(action_Unique);
        registerReceiver(broadcastReceiver, filter);
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            StringBuilder msg = new StringBuilder();
            String action = intent.getAction();
            msg.append("action: ").append(action).append("\n");
            msg.append("extras:\n");
            Bundle extras = intent.getExtras();
            if (extras != null) {
                for (String key : extras.keySet()) {
                    msg.append("    ").append(key).append(" : ").append(extras.get(key)).append("\n");
                }
            }

            Log.e("VA", "recv info: \n" + msg);
            recvInfo.setText(msg);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
