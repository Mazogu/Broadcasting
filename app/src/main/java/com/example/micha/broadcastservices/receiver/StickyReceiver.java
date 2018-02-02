package com.example.micha.broadcastservices.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class StickyReceiver extends BroadcastReceiver {

    StickyInteractor sticky;
    public static final String GET_STICKY = "Get Sticky Broadcast";

    public StickyReceiver(StickyInteractor sticky) {
        this.sticky = sticky;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        sticky.stickyMessage(intent.getStringExtra("data"));
    }

    public interface StickyInteractor{
        public void stickyMessage (String s);
    }
}
