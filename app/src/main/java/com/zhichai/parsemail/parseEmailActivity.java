package com.zhichai.parsemail;

import androidx.appcompat.app.AppCompatActivity;
import com.zhichai.parsemail.EmailReceiver;

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
        EmailReceiver receiver = new EmailReceiver();

//        // parameters
//        String protocol = "pop3";
//        String host = "pop.gmail.com";
//        String port = "995";

        // for IMAP
        String protocol = "imap";
        String host = "imap.gmail.com";
        String port = "993";

        receiver.downloadEmails(protocol, host, port, address, password);

    }

    private void parseDomain(String address) {
        int idx = address.indexOf('@');
        String domain = address.substring(idx+1);
    }
}
