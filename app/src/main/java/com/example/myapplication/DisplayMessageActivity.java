package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;


public class DisplayMessageActivity extends MainActivity {
    private static CountDownTimer timer;
    private static boolean cancelled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        this.cancelled = false;
        if (s.email.length() != 0){
            updateText(s.email, (TextView) findViewById(R.id.E));
        }else{
            updateText("NONE", (TextView) findViewById(R.id.E));
        }

        initTimer();
    }

    private void initTimer(){
        Long mill = 1 + (long)(this.s.hours * 1000 * 3600);
        updateText(Long.toString(mill/1000), (TextView) findViewById(R.id.tV1));

        this.timer = new CountDownTimer(mill, 1000) {

            public void onTick(long millisUntilFinished) {
                updateText(Long.toString(millisUntilFinished/1000 - 1), (TextView) findViewById(R.id.tV1));
            }

            public void onFinish() {
                if (!cancelled){
                    send();
                }

                //After the countdown finishes, the email will be sent
            }
        };
    }

    //Updates the time textView
    public void updateText(String str, TextView t) {
        //TextView textView = (TextView) findViewById(R.id.tV1);
        t.setText(str);
    }

    public void start(View view){

        this.timer.start();
    }

    public void cancel(View view){
        this.timer.cancel();
        this.cancelled = true;
        this.finish();
    }



}
