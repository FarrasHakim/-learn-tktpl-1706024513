package id.ac.ui.cs.mobileprogramming.farras.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Test Debugging", "Hello There. Ini On Create");
    }

    public void onClick(View v) {
        EditText nameField = findViewById(R.id.name_input);
        TextView greetText = findViewById(R.id.greet_text);

        if (!nameField.getText().toString().equals("")) {
            greetText.setText(StaticFunctions.greetUser(nameField.getText().toString()));
        } else {
            Toast toast = Toast.makeText(v.getContext(), "Masukkan Namamu", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}