package id.ac.ui.cs.mobileprogramming.farras.myfirstapp;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class CounterService extends Service {

    private long counter;
    private String counterText;
    private Handler mHandler = new Handler();
    private final int REFRESH_RATE = 100;

    @Override
    public void onCreate() {
        Log.d("Log Debug: ", "Create Service");
        super.onCreate();
        counter = 0;

        mHandler.removeCallbacks(startCounter);
        mHandler.postDelayed(startCounter, 0);
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacks(startCounter);
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Log Debug: ", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Log Debug: ", "Binding Service");
        return null;
    }

    private void updateCounter (float currCounter){
        counterText = String.valueOf(currCounter);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("counter", counterText);
        Log.d("Log Debug: ", "Sending BroadCast");
        sendBroadcast(intent);
        Log.d("Log Debug: ", "Sending BroadCast Done");
    }

    private Runnable startCounter = new Runnable() {
        @Override
        public void run() {
            counter += 1;
            Log.d("Log Debug: ", String.valueOf(counter));
            updateCounter(counter);
            Log.d("Log Debug: ", "Counter Updated");
            mHandler.postDelayed(this, REFRESH_RATE);
        }
    };

}
