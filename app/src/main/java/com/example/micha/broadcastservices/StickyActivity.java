package com.example.micha.broadcastservices;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.micha.broadcastservices.receiver.StickyReceiver;

public class StickyActivity extends AppCompatActivity implements StickyReceiver.StickyInteractor {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sticky);
        StickyReceiver receiver = new StickyReceiver(this);
        IntentFilter filter = new IntentFilter(StickyReceiver.GET_STICKY);
        registerReceiver(receiver, filter);
    }

    @Override
    public void stickyMessage(String s) {
        text = findViewById(R.id.stickyText);
        text.setText(s);
    }
}
