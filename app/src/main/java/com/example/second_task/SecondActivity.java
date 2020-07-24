package com.example.second_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static String TEXT = "TEXT";

    private TextView mTextView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button2);

        Bundle bundle = getIntent().getExtras();
        mTextView.setText(bundle.getString(TEXT));

    }
}