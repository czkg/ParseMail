package com.zhichai.parsemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class parseEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_email);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String address = intent.getStringExtra("address");
        String password = intent.getStringExtra("password");
    }

    private
}
