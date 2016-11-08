package org.esiea.remy_ranaivo.projet;

import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.security.AccessController.getContext;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        GetBeersService.startActionBeer(this);

        IntentFilter intentFilter = new IntentFilter(MainActivity.BEERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BeerUpdate(),intentFilter);

        /*BeerDbHelper db_helper = new BeerDbHelper(this);
        SQLiteDatabase db = db_helper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(BeerDbHelper.BeerEntry.CBEERNAME, "chouffe");TAG
        values.put(BeerDbHelper.BeerEntry.CDESC,"good beer" );

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(BeerDbHelper.BeerEntry.TABLE_NAME, null, values);*/

    }


}
