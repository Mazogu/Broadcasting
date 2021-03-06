package com.example.micha.broadcastservices.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.micha.broadcastservices.model.Taco;

import java.util.List;

public class ListReceiver extends BroadcastReceiver {

    public static final String LIST_ACTION = "GetTheList";
    private static final String TAG = ListReceiver.class.getSimpleName();
    ListGetter acquire;

    public ListReceiver(ListGetter acquire) {
        this.acquire = acquire;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast
        List<Taco> list = intent.getParcelableArrayListExtra("list");
        //Log.d(TAG, "onReceive: "+list.toString());
        acquire.getList(list);

    }

    public interface ListGetter{
        public void getList(List<Taco> tacos);
    }
}
