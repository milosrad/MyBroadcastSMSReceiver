package com.example.user.mybroadcastsmsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by User on 11.6.2016.
 */
public class CustomBroadcastReceiver extends BroadcastReceiver {

    private SmsManager sms = SmsManager.getDefault();


    @Override
    public void onReceive(Context context, Intent intent) {

        final Bundle bundle = intent.getExtras();

        String sendNum="";


        try{

            if(bundle!=null){

                final Object[] pdusObj = (Object[]) bundle.get("pdus");


                for (int i=0; i<pdusObj.length;i++){

                    SmsMessage currentmessage= SmsMessage.createFromPdu((byte[])pdusObj[i]);

                    String phoneNumber= currentmessage.getDisplayOriginatingAddress();

                    sendNum= phoneNumber;

                    String message= currentmessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: "+ sendNum + "; message: " + message);

                    Toast.makeText(context,"senderNum:"+ sendNum + "; message: " + message,Toast.LENGTH_LONG).show();

                    //    sms.sendTextMessage(senderNum,null,"Ne smaraj",null,null);



                }

                if(sendNum.equalsIgnoreCase("+381641532587")){

                    sms.sendTextMessage(sendNum,null,"Ne smaraj!",null,null);

                }


            }

        } catch (Exception e){

            Log.e("SmsReceiver","Exception smsReceiver"+e);

        }

        Toast.makeText(context,"Novi SMS je upravo stigao",Toast.LENGTH_LONG).show();

        if(sendNum.equalsIgnoreCase("+381641532587")){

            sms.sendTextMessage(sendNum,null,"Ne smaraj!",null,null);
            abortBroadcast();

        }

        if (sendNum.equalsIgnoreCase("+381641243808")){

            sms.sendTextMessage(sendNum,null,"Zovem te ubrzo! Veliki pozdrav!",null,null);
            abortBroadcast();

        }




    }
}
