package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void onClickBtn2 (View view){
        Intent intent_2  = new Intent(this, MainActivity.class);
        Toast.makeText(getApplicationContext(), "Opening activity 1...", Toast.LENGTH_SHORT).show();
        startActivity(intent_2);
    }
}