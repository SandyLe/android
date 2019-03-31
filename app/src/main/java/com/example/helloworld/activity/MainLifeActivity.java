package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.example.helloworld.R;

public class MainLifeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainLifeActivity.this,"On Create", Toast.LENGTH_SHORT).show();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_life_layout);
        Button btnToNormal = findViewById(R.id.btnToNormalActivity);
        Button btnToDialog = findViewById(R.id.btnToDialogActivity);
        btnToNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLifeActivity.this, NomalActivity.class);
                startActivity(intent);
            }
        });
        btnToDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLifeActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainLifeActivity.this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainLifeActivity.this,"onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainLifeActivity.this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainLifeActivity.this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainLifeActivity.this, "onDestory", Toast.LENGTH_SHORT).show();
    }
}
