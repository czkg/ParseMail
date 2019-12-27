package com.zhichai.parsemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class MainActivity extends AppCompatActivity {
    private EditText user;
    private EditText pass;
    private EditText subject;
    private EditText body;
    private EditText recipient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText textEmailAddress = (EditText) findViewById(R.id.emailAddress);
        final EditText textEmailPassword = (EditText) findViewById(R.id.emailPassword);
        Button submitButton = (Button) findViewById(R.id.submitButton);

//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String emailAddress = textEmailAddress.getText().toString();
//                String emailPassword = textEmailPassword.getText().toString();
//            }
//        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, parseEmailActivity.class);
        EditText textEmailAddress = (EditText) findViewById(R.id.emailAddress);
        EditText textEmailPassword = (EditText) findViewById(R.id.emailPassword);

        String emailAddress = textEmailAddress.getText().toString();
        String emailPassword = textEmailPassword.getText().toString();
        intent.putExtra("address", emailAddress);
        intent.putExtra("password", emailPassword);
        MainActivity.this.startActivity(intent);
    }
}
