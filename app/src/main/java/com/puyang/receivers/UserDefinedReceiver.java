package com.puyang.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.puyang.justforfun.MainActivity;

/**
 * Created by yangpu on 7/3/16.
 */
public class UserDefinedReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(MainActivity.TAG_RECEIVER)) {
            Toast.makeText(context, "I am here for you!", Toast.LENGTH_LONG).show();
            abortBroadcast();
        }
    }
}
