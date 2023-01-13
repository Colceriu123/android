package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new Fragment1());
    }

    public void goToNext(View view) {
        if(getCurrentFragment() instanceof Fragment1){
            replaceFragment(new Fragment2());
        } else if(getCurrentFragment() instanceof Fragment2){
            replaceFragment(new Fragment3());
        } else if(getCurrentFragment() instanceof Fragment3){
            replaceFragment(new Fragment1());
        }

    }

    public void goToPrevious(View view) {
        if(getCurrentFragment() instanceof Fragment1){
            replaceFragment(new Fragment3());
        } else if(getCurrentFragment() instanceof Fragment2){
            replaceFragment(new Fragment1());
        } else if(getCurrentFragment() instanceof Fragment3){
            replaceFragment(new Fragment2());
        }

    }

    public void goToDetails(View view) {
        Intent detailsIntent = new Intent(this, Details.class);

        String frame = getFragmentName(getCurrentFragment());
        Log.d("FRAME", frame.toString());

        detailsIntent.putExtra("details",frame);

        startActivity(detailsIntent);
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.frameLayout);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private String getFragmentName(Fragment fragment) {
        switch(String.valueOf(fragment).charAt(8) ){
            case '1': return "Details1";

            case '2': return "Details2";

            case '3': return "Details3";

            default: return "";
        }
    }

    }



