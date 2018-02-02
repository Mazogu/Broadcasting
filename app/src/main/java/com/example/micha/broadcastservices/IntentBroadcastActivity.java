package com.example.micha.broadcastservices;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.micha.broadcastservices.model.Taco;
import com.example.micha.broadcastservices.receiver.ListReceiver;
import com.example.micha.broadcastservices.service.ListIntentService;

import java.util.ArrayList;
import java.util.List;

public class IntentBroadcastActivity extends AppCompatActivity implements ListReceiver.ListGetter{
    private static final String TAG = IntentBroadcastActivity.class.getSimpleName();
    List<Taco> tacos;
    ListReceiver receiver;
    private RecyclerView recycle;
    private TacoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_broadcast);
        recycle = findViewById(R.id.recycle);
        tacos = new ArrayList<>();
        receiver = new ListReceiver(this);
        IntentFilter filter = new IntentFilter(ListReceiver.LIST_ACTION);
        adapter = new TacoAdapter(tacos);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recycle.setAdapter(adapter);
        recycle.setLayoutManager(manager);
        registerReceiver(receiver, filter);
    }

    @Override
    public void getList(List<Taco> tacos) {
        adapter.addToList(tacos);
        //Log.d(TAG, "getList: "+adapter.getTacos());
        adapter.notifyDataSetChanged();
    }

    public void getList(View view) {
        Intent start = new Intent(getApplicationContext(), ListIntentService.class);
        start.setAction(ListReceiver.LIST_ACTION);
        startService(start);
    }

    public void changeActivity(View view) {
        switch (view.getId()){
            case R.id.main:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.sticky:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
