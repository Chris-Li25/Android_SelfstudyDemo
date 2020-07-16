package com.android.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"receiver in MyBoardcastReceiver",Toast.LENGTH_SHORT).show();
        Log.e("TAG", "onReceive: " );
    }
}
