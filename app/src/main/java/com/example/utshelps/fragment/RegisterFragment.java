package com.example.utshelps.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.utshelps.R;
import com.example.utshelps.activity.MainActivity;
import com.example.utshelps.api.ApiManager;
import com.example.utshelps.api.model.StudentResponse;
import com.example.utshelps.model.Student;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private ApiManager mApiManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mApiManager = ApiManager.getInstance();
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

        // TODO: Set language to default to English
        // TODO: Set country to default to Australia

        // TODO: Add degree status!!!
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

        return createdView;
    }

    private void attemptRegister() {
        boolean error = false;

        String preferredName = getPreferredName();
        String contactNumber = mContactNumberEditText.getText().toString();
        String gender = getGender();
        String degreeType = getDegree();
        int degreeYear = mYearSpinner.getSelectedItemPosition() + 1;
        String language = mLanguageSpinner.getSelectedItem().toString();
        String country = mCountrySpinner.getSelectedItem().toString();

        if (!isContactNumberValid(contactNumber)) {
            mContactNumberEditText.setError(getString(R.string.error_phone_number_invalid));
            mContactNumberEditText.requestFocus();
            error = true;
        }

        if (preferredName != null && !isPreferredNameValid(preferredName)) {
            mPreferredNameEditText.setError(getString(R.string.error_preferred_name_invalid));
            mPreferredNameEditText.requestFocus();
            error = true;
        }

        if (!error) {
            Student student = new Student();
            student.setPreferredName(preferredName);
            student.setContactNumber(contactNumber);
            student.setGender(gender);
            student.setDegreeType(degreeType);
            student.setDegreeYears(degreeYear);
            student.setFirstLanguage(language);
            student.setCountryOfOrigin(country);

            registerStudent(student);
        }
    }

    private String getPreferredName() {
        String text = mPreferredNameEditText.getText().toString();
        if (text.length() == 0) {
            return null;
        }
        return text;
    }

    private String getGender() {
        switch(mGenderRadioGroup.getCheckedRadioButtonId()) {
            case R.id.fragment_register_gender_male_radio_button:
                return Student.GENDER_MALE;
            case R.id.fragment_register_gender_female_radio_button:
                return Student.GENDER_FEMALE;
            case R.id.fragment_register_gender_x_radio_button:
                return Student.GENDER_X;
            default:
                return null;
        }
    }

    private String getDegree() {
        switch(mDegreeRadioGroup.getCheckedRadioButtonId()) {
            case R.id.fragment_register_degree_undergraduate_radio_button:
                return Student.DEGREE_UNDERGRAD;
            case R.id.fragment_register_degree_postgraduate_radio_button:
                return Student.DEGREE_POSTGRAD;
            default:
                return null;
        }
    }

    private boolean isPreferredNameValid(String preferredName) {
        Pattern preferredNamePattern = Pattern.compile("[A-Za-z]{1}[a-z]*");
        return preferredNamePattern.matcher(preferredName).matches();
    }

    private boolean isContactNumberValid(String contactNumber) {
        Pattern contactNumberPattern = Pattern.compile("[\\+]*[0-9]{8,11}");
        return contactNumberPattern.matcher(contactNumber).matches();
    }

    private void registerStudent(Student student) {
        Log.d(MainActivity.TAG, "Preferred name: " + student.getPreferredName());
        Log.d(MainActivity.TAG, "Contact number: " + student.getContactNumber());
        Log.d(MainActivity.TAG, "Gender: " + student.getGender());
        Log.d(MainActivity.TAG, "Degree years: " + student.getDegreeYears());
        Log.d(MainActivity.TAG, "Degree type: " + student.getDegreeType());
        Log.d(MainActivity.TAG, "Language: " + student.getFirstLanguage());
        Log.d(MainActivity.TAG, "Country: " + student.getCountryOfOrigin());

        Student jane = new Student();

        jane.setStudentId("12345678");
        jane.setDegreeType(Student.DEGREE_UNDERGRAD);
        jane.setDegreeYears(4);
        jane.setDegreeStatus(Student.DEGREE_STATUS_INTL);
        jane.setPreferredName("API Testtttt");
        jane.setFirstLanguage("English");
        jane.setCountryOfOrigin("France");

        Callback<StudentResponse> registerCallback = new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(MainActivity.TAG, "response is successful");
                } else {
                    Log.d(MainActivity.TAG, "response is insuccessful");
                }
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {

            }
        };

        mApiManager.register(registerCallback, jane);
    }

}
