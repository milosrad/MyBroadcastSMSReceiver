package com.example.user.mybroadcastsmsreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonSMS;

    public final String CUSTOM_INTENT= "nastava.cubes.primer.BROADCAST_SMS_RECEIVER";

    private Intent mCustomIntent= new Intent(CUSTOM_INTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonSMS=(Button)findViewById(R.id.buttonsms);

        mButtonSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}
