package id.ac.ui.cs.mobileprogramming.farras.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Log Debug: ", "On Create gan");
    }

    @Override
    protected void onRestart() {
        Log.d("Log Debug: " , "On Restart gan");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.d("Log Debug: " , "On Start gan");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("Log Debug: " , "On Stop gan");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Log Debug: " , "On Destroyed gan");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("Log Debug: " , "On Pause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("Log Debug: " , "On Resume gan");
        super.onResume();
    }

    public void onExitButtonPressed(View v) {
        resetCounter();
        super.onBackPressed();
    }

    public void onStartButtonPressed(View v) {
        Toast.makeText(this, "Starting Counter",
                Toast.LENGTH_SHORT).show();
        TextView counterText = findViewById(R.id.counterText);
        Log.d("Log Debug: " , "Starting Counter");
        counterText.setText("1");
        startService(new Intent(MainActivity.this, CounterService.class));
        Log.d("Log Debug: " , "Starting Done");
    }

    public void onStopButtonPressed(View v) {
        Toast.makeText(this, "Stop Counter",
                Toast.LENGTH_SHORT).show();
        Log.d("Log Debug: " , "Stop Counter");
        stopService(new Intent(MainActivity.this, CounterService.class));
    }

    public void onResetButtonPressed(View v) {
        resetCounter();
    }

    private BroadcastReceiver br = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("Log Debug: ", "Receive BroadCast");
            updateCounterText(intent);
        }
    };

    private void updateCounterText(Intent intent) {
        Log.d("Log Debug: ", "Updated Counter");
        if (intent.getExtras() != null) {
            String counterValue = intent.getStringExtra("counter");
            TextView counterText = findViewById(R.id.counterText);
            counterText.setText(counterValue);
        }
    }

    private void resetCounter() {
        stopService(new Intent(MainActivity.this, CounterService.class));
        TextView counterText = findViewById(R.id.counterText);
        counterText.setText("0");
    }

    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Toast.makeText(this, "Press the exit button to quit the app",
                Toast.LENGTH_SHORT).show();
    }

}