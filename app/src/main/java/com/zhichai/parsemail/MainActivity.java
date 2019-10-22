package com.zhichai.parsemail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        ImageButton gmailButton = (ImageButton) findViewById(R.id.gmailButton);
        ImageButton outlookButton = (ImageButton) findViewById(R.id.outlookButton);
        ImageButton qqButton = (ImageButton) findViewById(R.id.qqButton);
        ImageButton yahooButton = (ImageButton) findViewById(R.id.yahooButton);

        gmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
