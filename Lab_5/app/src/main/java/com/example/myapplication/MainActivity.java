package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private volatile boolean stopWorker = false;
    private Button btnVerify, btnStart;
    private int clickCount;
    private TextView trueValue;
    private TextView textWorker;
    private final Handler mainHandler = new Handler();
    private EditText leftVal, rightVal, playerChoice;
    private Integer nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftVal = findViewById(R.id.leftVal);
        rightVal = findViewById(R.id.rightVal);
        playerChoice = findViewById(R.id.playerChoice);
        trueValue = findViewById(R.id.trueValue);
        textWorker = findViewById(R.id.textWorker);

    }



    public void startGame(View view){
        stopWorker = false;
        nr  = getRandomNumber(Integer.parseInt(leftVal.getText().toString()), Integer.parseInt(rightVal.getText().toString()));
        startWorkerThread(60);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void startWorkerThread(int seconds) {
        stopWorker = false;
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            int randomWorkerNumber;

            @Override
            public void run() {
                for (int i = 0; i < seconds; i++) {
                    randomWorkerNumber = getRandomNumber(Integer.parseInt(leftVal.getText().toString()), Integer.parseInt(rightVal.getText().toString()));
                    if (stopWorker) {
                        return;
                    }

                    if (randomWorkerNumber == nr) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                            textWorker.setText("YOU LOST!");
                            trueValue.setText("The number was: " + nr);
                            }
                        });
                        stopWorker = true;
                        return;
                    }

                    int finalI = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int time = seconds - finalI;
                            textWorker.setText("WORKER PICK: " + randomWorkerNumber);
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

public void PlayerChoice(View view){

        int playerGuess = Integer.parseInt(playerChoice.getText().toString());
        if(playerChoice.getText().toString()==null){
            Toast.makeText(this, "Guess",Toast.LENGTH_SHORT).show();
        }
        else
            if(playerGuess==nr){
                stopWorker = true;
                Toast.makeText(this, "YOU WON!",Toast.LENGTH_LONG).show();
                trueValue.setText("The number was: " + nr);
            }
    }
}
