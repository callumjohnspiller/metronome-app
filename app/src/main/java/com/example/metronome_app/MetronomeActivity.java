package com.example.metronome_app;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MetronomeActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.metronome_app.MESSAGE";
    private Boolean metronomeRunning = false;
    private Button startStop;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.sendButton);
        send.setOnClickListener(v -> sendMessage(send));
        startStop = findViewById(R.id.metronomeStartStop);
        startStop.setOnClickListener(v -> metronomeToggle());

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void metronomeToggle() {
        metronomeRunning = !metronomeRunning;
        if (metronomeRunning) {
            startStop.setText(R.string.metronome_stop);
        } else {
            startStop.setText(R.string.metronome_start);
        }
    }
}