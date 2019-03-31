package com.example.helloworld.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.*;
import com.example.helloworld.R;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);

        TextView textView = findViewById(R.id.viewSecond);
        textView.setText(getIntent().getStringExtra("testData"));

        Button buttonToBaidu = findViewById(R.id.buttonBroswer);
        buttonToBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        Button buttonBack = findViewById(R.id.buttonSecondBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button buttonBackData = findViewById(R.id.buttonBackData);
        buttonBackData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hellow, Back Data");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        final ImageView imageView01 = findViewById(R.id.imageView01);
        imageView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               imageView01.setImageResource(R.drawable.sandylee);
            }
        });

        final ProgressBar progressBar = findViewById(R.id.progressbar1);

        Button btnToProgressBar = findViewById(R.id.btnToProgressBar);
        btnToProgressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//                }
                int progress = progressBar.getProgress();
                progress += 10;
                progressBar.setProgress(progress);
            }
        });

        Button btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(SecondActivity.this);
                dialog.setTitle("This is a dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this,"You click OK", Toast.LENGTH_SHORT).show();
                        ProgressDialog dialogprogress = new ProgressDialog(SecondActivity.this);
                        dialogprogress.setTitle("This is Progressing");
                        dialogprogress.setMessage("Loading...");
                        dialogprogress.setCancelable(true);
                        dialogprogress.show();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this, "You click Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello, BackData!");
        setResult(RESULT_OK, intent);
        finish();
    }
}
