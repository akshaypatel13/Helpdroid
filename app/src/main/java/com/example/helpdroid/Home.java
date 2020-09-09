package com.example.helpdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private TextView mTextMessage;
    ListView listView;

    private static final String TAG = "debug_info";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.contacts:
                    Intent a=new Intent(Home.this,contacts.class);
                    startActivity(a);
                    return true;
                case R.id.chat:
                    Intent ab=new Intent(Home.this,chat.class);
                    startActivity(ab);
                    return true;
                case R.id.hospital:
                    Intent abc=new Intent(Home.this,hospital.class);
                    startActivity(abc);
                    return true;
                case R.id.settings:
                    Intent abcd=new Intent(Home.this,settings.class);
                    startActivity(abcd);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getApplication().setTheme(R.style.Theme_AppCompat_DayNight);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

}
