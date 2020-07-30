package com.example.a4week2task;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SearchFragment extends Fragment {

    private EditText mEditText;
    private Button mButton;

    private SharedPreferencesHelper mSharedPreferencesHelper;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        mEditText = v.findViewById(R.id.search_edit);
        mButton = v.findViewById(R.id.search_button);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (mSharedPreferencesHelper.getSearchEngine()) {
                    case "2131558430":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/search?q=" + mEditText.getText().toString()));
                        startActivity(intent);
                        break;
                    case "2131558436":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru/search/?text=" + mEditText.getText().toString()));
                        startActivity(intent);
                        break;
                    case "2131558428":
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bing.com/search?q=" + mEditText.getText().toString()));
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

        return v;
    }
}