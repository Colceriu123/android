package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   ListView listViewNames;
   ArrayList<String> dynamicList;
   ArrayAdapter<String> listAdapter;
   Button btnAdd, btnRemove;
   EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNames =findViewById(R.id.listViewNames);
        dynamicList = new ArrayList<String>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dynamicList);
        listViewNames.setAdapter(listAdapter);

        name = findViewById(R.id.studentName);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAdapter.add(String.valueOf(name.getText().toString()));
                listAdapter.notifyDataSetChanged();
            }
        });

        btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dynamicList.remove(name.getText().toString());
                listAdapter.notifyDataSetChanged();
            }
        });
    }
}