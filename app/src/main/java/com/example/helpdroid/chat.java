package com.example.helpdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chat extends AppCompatActivity {

    Button chat_wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chat_wifi=(Button)findViewById(R.id.chat_wifi);
        chat_wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=getPackageManager().getLaunchIntentForPackage("net.usikkert.kouchat.android");
                startActivity(i);
            }
        });
    }
}
