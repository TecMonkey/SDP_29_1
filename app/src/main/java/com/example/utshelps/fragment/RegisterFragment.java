package com.example.utshelps.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.utshelps.R;

/**
 * Created by yaseen on 3/10/16.
 */

public class RegisterFragment extends Fragment {

    private EditText mPreferredNameEditText;
    private EditText mContactNumberEditText;
    private RadioGroup mGenderRadioGroup;
    private RadioGroup mDegreeRadioGroup;
    private Spinner mYearSpinner;
    private Spinner mLanguageSpinner;
    private Spinner mCountrySpinner;
    private Button mRegisterButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View createdView = inflater.inflate(R.layout.fragment_register, container, false);

        mPreferredNameEditText = (EditText) createdView.findViewById(R.id.fragment_register_preferred_name_edit_text);
        mContactNumberEditText = (EditText) createdView.findViewById(R.id.fragment_register_contact_number_edit_text);
        mGenderRadioGroup = (RadioGroup) createdView.findViewById(R.id.fragment_register_gender_radio_group);
        mDegreeRadioGroup = (RadioGroup) createdView.findViewById(R.id.fragment_register_degree_radio_group);
        mYearSpinner = (Spinner) createdView.findViewById(R.id.fragment_register_year_spinner);
        mLanguageSpinner = (Spinner) createdView.findViewById(R.id.fragment_register_language_spinner);
        mCountrySpinner = (Spinner) createdView.findViewById(R.id.fragment_register_country_spinner);
        mRegisterButton = (Button) createdView.findViewById(R.id.fragment_register_register_button);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegister();
            }
        });

        return createdView;
    }

    private void onRegister() {

    }
}
