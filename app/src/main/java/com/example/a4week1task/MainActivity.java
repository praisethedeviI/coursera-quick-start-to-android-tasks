package com.example.a4week1task;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MenuItem mSettings;
    private MenuItem mSearch;
    private MenuItem mExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ac_main, menu);
        mSettings = menu.findItem(R.id.settings);
        mSearch = menu.findItem(R.id.search);
        mExit = menu.findItem(R.id.exit);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                showMessage(R.string.settings);
                break;
            case R.id.search:
                showMessage(R.string.search);
                break;
            case R.id.exit:
                showMessage(R.string.exit);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showMessage(@StringRes int str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}