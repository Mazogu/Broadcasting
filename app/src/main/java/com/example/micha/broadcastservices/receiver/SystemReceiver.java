package com.example.micha.broadcastservices.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SystemReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        switch (intent.getAction()){
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean airplane = intent.getBooleanExtra("state", false);
                if(airplane){
                    Toast.makeText(context, "Airplane mode on", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context, "Airplane mode off", Toast.LENGTH_SHORT).show();
                }
                break;
            case Intent.ACTION_BATTERY_LOW:
                Toast.makeText(context, "Battery Low", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_LOCALE_CHANGED:
                Toast.makeText(context, "Locale has changed", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Device is charging", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Device is now using battery power", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
