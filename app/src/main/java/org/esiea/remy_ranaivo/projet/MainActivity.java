package org.esiea.remy_ranaivo.projet;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    static public RecyclerView rv;
    private DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv_view = (TextView)findViewById(R.id.tv_hello_world);

        dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                tv_view.setText(i+"/"+i1+"/"+i2);
            }
        }, 2016,11,7);

        rv = (RecyclerView) findViewById(R.id.rv_biere);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        rv.setAdapter(new BiersAdapter(getBiersFromFile()));

    }


    public void notification_test(){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, mBuilder.build());
    }

    public JSONArray getBiersFromFile(){
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "UTF-8"));
        }catch(IOException e){
            e.printStackTrace();
            return new JSONArray();
        }catch(JSONException e){
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public void fct(View v){
        Toast.makeText(this, "Toast test : coucou", Toast.LENGTH_SHORT).show();
        dpd.show();
        notification_test();
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public static final String BEERS_UPDATE="com.octip.cours.inf4042_11.BEERS_UPDATE";


}





