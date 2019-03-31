package com.example.helloworld.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.helloworld.R;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.LENGTH_SHORT显示时间短，TOAST.LENGTH_LONG显示时间长
                Toast.makeText(FirstActivity.this,"You clicked Button1", Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonToSecond = findViewById(R.id.buttonToSecond);
        buttonToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button buttonIntent = findViewById(R.id.buttonIntent);
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.activity.1ACTION_START");
                intent.addCategory("android.intent.category.MY_CATEGORY");
                String data = "This data from the activity before";
                intent.putExtra("testData",data);
                startActivity(intent);
            }
        });

        Button buttonToSecondBack = findViewById(R.id.btnToSecondBack);
        buttonToSecondBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });

        Button buttonToLife = findViewById(R.id.btnToLifeActivity);
        buttonToLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, MainLifeActivity.class);
                startActivity(intent);
            }
        });

        Button buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.first_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.meneu01Add:
                Toast.makeText(this, "you click add menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu01Del:
                Toast.makeText(this,"you click remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1 :
                if (resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    TextView tv = findViewById(R.id.textViewDataBack);
                    tv.setText(returnData);
                }
                break;
            default:
        }
    }
}
