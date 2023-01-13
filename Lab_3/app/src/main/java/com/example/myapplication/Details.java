package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



//import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String fragment = getIntent().getStringExtra("details");

        switch (fragment.toString()){
            case "Details1":
                replaceFragment(new Details1());
                break;
            case "Details2":
                replaceFragment(new Details2());
                break;
            case "Details3":
                replaceFragment(new Details3());
                break;
        }
    }

    public void back(View view){
        Intent mainPageIntent = new Intent(this, MainActivity.class);
        startActivity(mainPageIntent);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.details, fragment);
        fragmentTransaction.commit();
    }

}
