package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.myapplication.TIMER";
    public static Save s = new Save();
    public static Eml e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.e = new Eml("k1836404332b@sina.com", "1836404332@qq.com", "skidkbmwapaybbif");
    }

    public void saveChanges(View view){
        EditText email = (EditText) findViewById(R.id.email);
        EditText content = (EditText) findViewById(R.id.editText2);
        EditText hours = (EditText) findViewById(R.id.editText5);
        EditText subject = (EditText) findViewById(R.id.editText3);
        if (hours.length() == 0){
            this.s = new Save(email.getText().toString(), subject.getText().toString(),
                    content.getText().toString(), 0);
        }else{
            this.s = new Save(email.getText().toString(), subject.getText().toString(), content.getText().toString(),
                    Double.parseDouble(hours.getText().toString()));
        }



        Toast toast = Toast.makeText(this, "Saved", Toast.LENGTH_LONG);
        toast.show();

    }

    public void toTimer(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendEmail(View view){
        Toast toast = Toast.makeText(this, "Sending Email to " + s.email, Toast.LENGTH_LONG);
        toast.show();
        send();
        Toast toast1 = Toast.makeText(this, "Sent", Toast.LENGTH_LONG);
        toast1.show();
    }

    protected static void send(){

        //open a new thread, android doesn't allow any networking in the main thread
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    e = new Eml(s.email, "", "");
                    //my email address and SMTP server password were deleted due to the obvious reason
                    //Fill yours like this: e = new Eml(s.email, Email, SMTP server password);

                    e.send(s.subject, s.content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }


}
