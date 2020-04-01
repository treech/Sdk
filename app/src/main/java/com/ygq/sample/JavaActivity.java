package com.ygq.sample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ygq.sdk.widget.FrameStateLayout;

public class JavaActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        FrameStateLayout statusView = findViewById(R.id.stateLayout);

    }
}
