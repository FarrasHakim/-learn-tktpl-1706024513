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
import api.ApiClient;
import api.ApiInterface;
import api.WifiData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    WifiManager mWifiManager;
    private ApiInterface service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        service = ApiClient.getClient().create(ApiInterface.class);
        if (mWifiManager.isWifiEnabled() == false)
        {
            // If wifi disabled then enable it
            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled",
                    Toast.LENGTH_LONG).show();
            mWifiManager.setWifiEnabled(true);
        }

    }

    private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            Log.wtf("BRMainActivity", "ReceiveIntent" + intent.getAction());
            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                List<ScanResult> mScanResults = mWifiManager.getScanResults();
                for (ScanResult result:mScanResults) {
                    Call<ResponseBody> call = service.addWifi(
                            new WifiData(
                                    result.SSID,
                                    result.BSSID,
                                    result.capabilities,
                                    result.frequency,
                                    result.channelWidth));
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                Log.wtf("BRMAINACTIVITY", "Berhasil POST");
                                Toast.makeText(getApplication(), "Berhasil POST", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(getApplication(), "Failed because: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
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
        Intent receiverIntent = registerReceiver(mWifiScanReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
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