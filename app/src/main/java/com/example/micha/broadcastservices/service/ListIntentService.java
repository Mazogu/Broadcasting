package com.example.micha.broadcastservices.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Parcelable;

import com.example.micha.broadcastservices.model.Taco;
import com.example.micha.broadcastservices.receiver.ListReceiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class ListIntentService extends IntentService {
    List<Taco> randomTacoList;
    public ListIntentService() {
        super("ListIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String[] cheeses = new String[]{"Mozzarella","Feta","Cheddar","Swiss"};
        String[] meats = new String[]{"Beef,Chicken,Shrimp,Tofu"};
        String[] shells = new String[]{"Soft","Hard"};
        String[] salsa = new String[]{"Sweet","Mild","Spicy","Ignites Mouth"};
        randomTacoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Taco randomTaco = new Taco(cheeses[new Random().nextInt(cheeses.length)],meats[new Random().nextInt(meats.length)],
                    shells[new Random().nextInt(shells.length)],salsa[new Random().nextInt(salsa.length)]);
            randomTacoList.add(randomTaco);
        }
        Intent broadcastIntent = new Intent(ListReceiver.LIST_ACTION);
        broadcastIntent.putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) randomTacoList);
        sendBroadcast(broadcastIntent);
    }
}
