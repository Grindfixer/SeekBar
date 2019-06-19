package com.jwn.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView) findViewById(R.id.resultID);
        seekBar = (SeekBar)findViewById(R.id.seekBarID);
        resultTextView.setText("Pain Level:" + seekBar.getProgress() + "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {// when seekbar changes
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 resultTextView.setText("Pain Level:" + seekBar.getProgress() + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                  Log.d("SB", "OnStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                // if pain level is above 7, turn text Red otherwise it's Gray
                if (seekBar.getProgress() >= 7) {
                    resultTextView.setTextColor(Color.RED);
                }else {
                    resultTextView.setTextColor(Color.GRAY);
                }

                 //Log.d("SB", "OnStopTrackingTouch");
            }
        });
    }
}
