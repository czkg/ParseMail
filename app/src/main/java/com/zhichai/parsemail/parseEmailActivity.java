package com.zhichai.parsemail;

import androidx.appcompat.app.AppCompatActivity;
import com.zhichai.parsemail.EmailReceiver;
import com.zhichai.parsemail.Email;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class parseEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_email);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String address = intent.getStringExtra("address");
        String password = intent.getStringExtra("password");
        Email email = new EmailBuilder()
                .address(address)
                .password(password)
                .buildEmail();
        EmailReceiver receiver = new EmailReceiver();
        receiver.downloadEmails(email.getProtocol(),
                                email.getHost(),
                                email.getPort(),
                                email.getAddress(),
                                email.getPassword(),
                                futureDate,
                                pastDate);

    }

    public void setStartTime(View view) {
        
    }

    public void setEndTime(View view) {

    }
}
