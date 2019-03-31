package com.example.helloworld.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.example.helloworld.R;

public class NomalActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.normal_layout);
    }
}
