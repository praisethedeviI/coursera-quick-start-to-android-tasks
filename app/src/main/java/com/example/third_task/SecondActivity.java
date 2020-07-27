package com.example.third_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static String TEXT = "TEXT";

    private TextView mTextView;
    private Button mBtnToWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = findViewById(R.id.textView);
        mBtnToWeb = findViewById(R.id.btn_to_web);

        final Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.getString(TEXT));

        mBtnToWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/search?q=" + bundle.getString(TEXT)));
                startActivity(intent);
            }
        });

    }
}