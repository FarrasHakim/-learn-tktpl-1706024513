package id.ac.ui.cs.mobileprogramming.farras.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WifiManager mWifiManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        if (mWifiManager.isWifiEnabled() == false)
        {
            // If wifi disabled then enable it
            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled",
                    Toast.LENGTH_LONG).show();
            mWifiManager.setWifiEnabled(true);
        }

        IntentFilter intentFilter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        Intent wifiIntent = registerReceiver(mWifiScanReceiver, intentFilter);
//        sendBroadcast(intent);
        Log.wtf("MainActivityOnCreate", "Habis Register Receiver");
        Log.wtf("MainActivityOnCreate", "Wifi Intent: " + wifiIntent);
        boolean successScan = mWifiManager.startScan();

        Log.wtf("MainActivityOnCreate", "Scan Status: " + successScan);
    }

    private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            Log.wtf("BRMainActivity", "ReceiveIntent" + intent.getAction());
            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                List<ScanResult> mScanResults = mWifiManager.getScanResults();
                for (ScanResult result:mScanResults) {
                    Log.wtf("BRMainActivity", String.valueOf(result.SSID));
                }
            }
        }
    };

    @Override
    protected void onResume() {
        registerReceiver(mWifiScanReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        this.unregisterReceiver(mWifiScanReceiver);
    }

    public void onClick(View v) {
        boolean successScan = mWifiManager.startScan();
        Intent receiverIntent = registerReceiver(mWifiScanReceiver, new IntentFilter(WifiManager.ACTION_REQUEST_SCAN_ALWAYS_AVAILABLE));
        String textMessage = "Success Scan: " + successScan + "\n"
                + "Wifi Info: " + mWifiManager.getConnectionInfo() + "\n"
                + "Wifi State: " + mWifiManager.getWifiState() + "\n"
                + "Wifi Scan Results: " + mWifiManager.getScanResults().size() + "\n"
                + "Wifi Connection State: " + mWifiManager.getWifiState() + "\n"
                + "Receiver Intent: " + receiverIntent;

        TextView textView = findViewById(R.id.wifiState);
        textView.setText(textMessage);
        Toast.makeText(this, textMessage, Toast.LENGTH_LONG).show();
    }
}