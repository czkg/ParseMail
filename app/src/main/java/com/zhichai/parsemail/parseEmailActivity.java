package com.zhichai.parsemail;

import androidx.appcompat.app.AppCompatActivity;
import com.zhichai.parsemail.EmailReceiver;
import com.zhichai.parsemail.Email;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class parseEmailActivity extends AppCompatActivity {
    final EditText startTimeText = (EditText) findViewById(R.id.startTimeText);
    final EditText endTimeText = (EditText) findViewById(R.id.endTimeText);
    final Button startTimeButton = (Button) findViewById(R.id.startTimeButton);
    final Button endTimeButton = (Button) findViewById(R.id.endTimeButton);

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

    public void onCreateDateDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                txtDate.setText(day + "-" + (month + 1) + "-" + year);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}
