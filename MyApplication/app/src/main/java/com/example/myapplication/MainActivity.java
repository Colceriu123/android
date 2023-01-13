package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*public void shortToastBtn(View view){
        Toast.makeText(getApplicationContext(),"Short Toast",Toast.LENGTH_SHORT).show();
    }
    public void longToastBtn(View view){
        Toast.makeText(getApplicationContext(),"Short Toast",Toast.LENGTH_LONG).show();
    }*/

    public void onClickBtn1 (View view){
        Intent intent_1  = new Intent(this, MainActivity2.class);
        Toast.makeText(getApplicationContext(), "Opening activity 2...", Toast.LENGTH_SHORT).show();
        startActivity(intent_1);
    }

}