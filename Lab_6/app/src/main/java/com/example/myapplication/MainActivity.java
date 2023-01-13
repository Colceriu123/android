package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    EditText period;
    EditText volume;
    EditText duration;
    MyBoundService myBoundService;
    boolean isConnected = false;
    ServiceConnection serviceConnection;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        period = findViewById(R.id.period);
        volume = findViewById(R.id.volume);
        duration = findViewById(R.id.duration);
        btnPlay = findViewById(R.id.play);
        tvStatus = findViewById(R.id.textView2);

        myBoundService = new MyBoundService();
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.i("SERVICE CONNECT", "onServiceConnected: ");
                MyBoundService.MyBinder binder = (MyBoundService.MyBinder) iBinder;
                myBoundService = binder.getBoundService();
                isConnected = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Log.i("SERVICE DISSCONNECT", "onServiceDisconnected: ");
                isConnected = false;
            }
        };
        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }
    public void onPlaySound (View view){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                myBoundService.play(Integer.parseInt(duration.getText().toString()), Float.parseFloat(volume.getText().toString()));
            }
        }, 1000L * Integer.parseInt(period.getText().toString()));
    }
}