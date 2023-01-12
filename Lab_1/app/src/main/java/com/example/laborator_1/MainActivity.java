package com.example.laborator_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view){
        TextView textView1 = findViewById(R.id.textView1);
        EditText editTextBox1 = findViewById(R.id.edtTxt1);
        textView1.setText("First name: " + editTextBox1.getText().toString());

        TextView textView2 = findViewById(R.id.textView2);
        EditText editTextBox2 = findViewById(R.id.edtTxt2);
        textView2.setText("Last name: " + editTextBox2.getText().toString());

        TextView textView3 = findViewById(R.id.textView3);
        EditText editTextBox3 = findViewById(R.id.edtTxt3);
        textView3.setText("Email: " + editTextBox3.getText().toString());
    }
}