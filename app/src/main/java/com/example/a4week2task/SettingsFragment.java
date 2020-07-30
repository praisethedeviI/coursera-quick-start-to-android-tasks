package com.example.a4week2task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonGoogle;
    private RadioButton mRadioButtonYandex;
    private RadioButton mRadioButtonBing;

    private SharedPreferencesHelper mSharedPreferencesHelper;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        mRadioGroup = v.findViewById(R.id.rg_search_settings);
        mRadioButtonGoogle = v.findViewById(R.id.rb_google);
        mRadioButtonYandex = v.findViewById(R.id.rb_yandex);
        mRadioButtonBing = v.findViewById(R.id.rb_bing);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_google:
                        mSharedPreferencesHelper.changeChoice(String.valueOf(R.string.google_text));
                        break;
                    case R.id.rb_yandex:
                        mSharedPreferencesHelper.changeChoice(String.valueOf(R.string.yandex_text));
                        break;
                    case R.id.rb_bing:
                        mSharedPreferencesHelper.changeChoice(String.valueOf(R.string.bing_text));
                        break;
                    default:
                        break;
                }
            }
        });
        return v;
    }
}
