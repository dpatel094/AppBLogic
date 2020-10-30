package com.e.newapp;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private NotificationManager mNotificationManager;
    private int SIMPLE_NOTFICATION_ID;
    String ACTION = "my.custom.action.tag.fordemo";


    public MyBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
            String inputA = intent.getStringExtra("input1");
            String inputB = intent.getStringExtra("input2");
           // Toast.makeText(context, "A   "+inputA, Toast.LENGTH_SHORT).show();
        if (inputA != null || inputB != null) {
            calll(context, inputA, inputB);
        }
    }

    private void calll(Context context, String inputA, String inputB) {

        int Cal = Integer.parseInt(inputA) + Integer.parseInt(inputB);

        Intent intent=new Intent();
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("input1", String.valueOf(Cal));
       // intent.putExtra("input2", inputB);
        intent.setComponent(new ComponentName("com.e.newappb","com.e.newappb.MyBroadcastReceiver"));
        context.sendBroadcast(intent);
    }

}