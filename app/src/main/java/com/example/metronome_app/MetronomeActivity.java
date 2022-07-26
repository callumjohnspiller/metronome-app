package com.example.metronome_app;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MetronomeActivity extends AppCompatActivity {

    private Boolean metronomeRunning = false;
    private Button startStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startStop = findViewById(R.id.metronomeStartStop);

        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metronomeToggle();
            }
        });
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