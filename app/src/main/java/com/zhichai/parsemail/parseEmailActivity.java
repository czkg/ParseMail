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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class parseEmailActivity extends AppCompatActivity {
    Email email;
    EmailReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_email);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String address = intent.getStringExtra("address");
        String password = intent.getStringExtra("password");
        email = new EmailBuilder()
                .address(address)
                .password(password)
                .buildEmail();
        receiver = new EmailReceiver();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public void onCreateDateDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        int bid = v.getId();
        int tid = 0;
        if(bid == R.id.startTimeButton) {
            tid = R.id.startTimeText;
        }
        else if(bid == R.id.endTimeButton) {
            tid = R.id.endTimeText;
        }
        final EditText txtDate = (EditText) findViewById(tid);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                txtDate.setText((month + 1) + "-" + day + "-" + year);
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void onClickSubmitButton(View v) {
        final EditText startEditText = (EditText) findViewById(R.id.startTimeText);
        final EditText endEditText = (EditText) findViewById(R.id.endTimeText);
        String startTimeString = startEditText.getText().toString();
        String endTimeString = endEditText.getText().toString();

//        int ll = startTime.indexOf('-');
//        int rr = startTime.indexOf('-', ll + 1);
//        String sMonth = startTime.substring(0, ll);
//        String sDay = startTime.substring(ll+1, rr);
//        String sYear = startTime.substring(rr+1);
//
//        ll = endTime.indexOf('-');
//        rr = endTime.indexOf('-', ll + 1);
//        String eMonth = endTime.substring(0, ll);
//        String eDay = endTime.substring(ll+1, rr);
//        String eYear = endTime.substring(rr+1);
//
//        int isYear = Integer.parseInt(sYear);
//        int isMonth = Integer.parseInt(sMonth);
//        int isDay = Integer.parseInt(sDay);
//        int ieYear = Integer.parseInt(eYear);
//        int ieMonth = Integer.parseInt(eMonth);
//        int ieDay = Integer.parseInt(eDay);

//        Date sDate = new Date(isYear, isMonth, isDay);
//        Date eDate = new Date(ieYear, ieMonth, ieDay);

        Date startDate = parseDate(startTimeString);
        Date endDate = parseDate(endTimeString);

        receiver.downloadEmails(email.getProtocol(),
                email.getHost(),
                email.getPort(),
                email.getAddress(),
                email.getPassword(),
                startDate,
                endDate);
    }

}
