package com.example.micha.broadcastservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeActivity(View view) {
        switch (view.getId()){
            case R.id.sticky:

                break;

            case R.id.intent:
                Intent intent = new Intent(getApplicationContext(), IntentBroadcastActivity.class);
                startActivity(intent);
                break;
        }
    }
}
