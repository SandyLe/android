package com.example.helloworld.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.example.helloworld.R;

public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}
