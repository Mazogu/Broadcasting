package com.example.micha.broadcastservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.micha.broadcastservices.model.Taco;
import com.example.micha.broadcastservices.receiver.ListReceiver;
import com.example.micha.broadcastservices.service.ListIntentService;

import java.util.ArrayList;
import java.util.List;

public class IntentBroadcastActivity extends AppCompatActivity implements ListReceiver.ListGetter{
    List<Taco> tacos;
    ListReceiver receiver;
    private RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_broadcast);
        recycle = new RecyclerView(this);
        tacos = new ArrayList<>();
        receiver = new ListReceiver(this);
    }

    @Override
    public void getList(List<Taco> tacos) {
        tacos.addAll(tacos);
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
}
