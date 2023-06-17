package com.example.multithreadingexample;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
public class MainActivity extends AppCompatActivity {
    public void startNewThread() {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i &lt; 5; i++) {
                    Log.d(&quot;MyThread&quot;, &quot;Doing work in new thread: &quot; + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        myThread.start();
    }
    public void startAnotherThread() {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i &lt; 5; i++) {
                    Log.d(&quot;MyThread&quot;, &quot;Doing work in new thread: &quot; + i*10);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        myThread.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startNewThread();
        startAnotherThread();
    }
}