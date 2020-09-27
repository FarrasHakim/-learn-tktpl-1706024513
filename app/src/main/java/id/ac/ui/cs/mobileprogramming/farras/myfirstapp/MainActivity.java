package id.ac.ui.cs.mobileprogramming.farras.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Test Debugging", "Hello There. Ini On Create");
    }

    public void onClick(View v) {
        Toast toast = Toast.makeText(v.getContext(), "Berhasil diklik", Toast.LENGTH_SHORT);
        toast.show();
    }
}