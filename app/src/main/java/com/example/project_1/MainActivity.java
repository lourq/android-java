package com.example.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button b;
    private TextView t;
    private TextView headerText;
    private Date targetDate;
    private Date currentDate;
    private String timeLeft;
    private int buttonSize = 100;
    private int buttonClickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        b = findViewById(R.id.button);
//        t = findViewById(R.id.textView);
//        headerText = findViewById(R.id.headerTime);
//        try {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//            targetDate = sdf.parse("2024-02-08 08:50:00");
//
//            currentDate = Calendar.getInstance().getTime();
//
//            long diff = targetDate.getTime() - currentDate.getTime();
//
//            long days = TimeUnit.MILLISECONDS.toDays(diff);
//            long hours = TimeUnit.MILLISECONDS.toHours(diff) % 24;
//            long minutes = TimeUnit.MILLISECONDS.toMinutes(diff) % 60;
//            long seconds = TimeUnit.MILLISECONDS.toSeconds(diff) % 60;
//
//            timeLeft = String.format(Locale.getDefault(),
//                    "Time Left -> %d д %d ч %d м %d секунд",
//                    days, hours, minutes, seconds);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(buttonClickCount < 20) {
//                    buttonSize += 30;
//                    buttonClickCount++;
//                    b.getLayoutParams().width = buttonSize;
//                    b.requestLayout();
//                    t.setText(String.valueOf(buttonClickCount));
//
//                } else {
//                    b.setBackgroundColor(Color.RED);
//                    b.setText("Broken T^T");
//                }
//
////                Toast.makeText(MainActivity.this,
////                        String.valueOf(timeLeft),
////                        Toast.LENGTH_SHORT).show();
//                headerText.setText(timeLeft);
//            }
//        });
    }

    public void func(View view) {
        Toast.makeText(this, "KNP202", Toast.LENGTH_SHORT).show();
    }
}
