package com.gzeinnumer.repeatprosesinterval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public boolean isRepeat = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reloadOtomatis();


    }

    private void displayData() {
        Toast.makeText(this, "repeat", Toast.LENGTH_SHORT).show();

    }

    //todo 80
    private void reloadOtomatis() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(3000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //CALL ANY METHOD OR ANY URL OR FUNCTION or any view
                                displayData();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };t.start();
    }

    //todo 81
    @Override
    protected void onStop() {
        super.onStop();
        isRepeat = false;
    }

    //todo 82
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    //todo 83
    @Override
    protected void onStart() {
        super.onStart();
        isRepeat =true;
        reloadOtomatis();
    }
}
