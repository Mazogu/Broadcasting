package com.example.micha.broadcastservices;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.micha.broadcastservices.receiver.StickyReceiver;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_BROADCAST_STICKY = 10;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.stickyMessage);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.BROADCAST_STICKY)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.BROADCAST_STICKY)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.BROADCAST_STICKY},
                        MY_PERMISSIONS_REQUEST_BROADCAST_STICKY);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

    }

    public void changeActivity(View view) {
        switch (view.getId()){
            case R.id.sticky:
                Intent stickIntent = new Intent(getApplicationContext(),StickyActivity.class);
                startActivity(stickIntent);
                break;

            case R.id.intent:
                Intent intent = new Intent(getApplicationContext(), IntentBroadcastActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void sendSticky(View view) {
        Intent intent = new Intent(StickyReceiver.GET_STICKY);
        intent.putExtra("data", edit.getText().toString());
        sendStickyBroadcast(intent);
    }
}
