package com.example.utshelps.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.utshelps.Constants;
import com.example.utshelps.R;

import java.util.regex.Pattern;

/**
 * Activity that a student will use to log in to the HELPS system.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText mStudentIdEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signInButton = (Button) findViewById(R.id.activity_login_sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptSignIn();
            }
        });

        mStudentIdEditText = (EditText) findViewById(R.id.activity_login_student_id_edit_text);
        mPasswordEditText = (EditText) findViewById(R.id.activity_login_student_password_edit_text);
    }

    /**
     * Attempts to sign the user in. If there is an input error, an error message is displayed.
     * <p/>
     * TODO: Actually sign a student in
     * Doesn't actually sign a student in at the moment, but it will.
     */
    public void attemptSignIn() {
        boolean error = false;

        String studentId = mStudentIdEditText.getText().toString();
        if (!isStudentIdValid(studentId)) {
            mStudentIdEditText.setError(getString(R.string.error_student_id_numbers));
            mStudentIdEditText.requestFocus();
            error = true;
        }

        String password = mPasswordEditText.getText().toString();
        if (password.length() < 6) {
            mPasswordEditText.setError(getString(R.string.error_password_six_characters));
            mPasswordEditText.requestFocus();
            error = true;
        } else if (password.length() > 20) {
            mPasswordEditText.setError(getString(R.string.error_password_twenty_characters));
            mPasswordEditText.requestFocus();
            error = true;
        }

        if (!error) {
            setResult(Constants.LOGIN_ACTIVITY_SUCCESS);
            finish();
        }
    }

    /**
     * Checks whether an inputted student id is valid.
     *
     * @param studentId
     * @return
     */
    private boolean isStudentIdValid(String studentId) {
        Pattern studentIdPattern = Pattern.compile("^[0-9]{8}$");
        return isPatternValid(studentIdPattern, studentId);
    }

    /**
     * Compares a string to a specified regex pattern
     * <p/>
     * This is just a utility function that wraps around the Matcher regex class.
     *
     * @param regexPattern the pattern to compare against
     * @param text         the text to compare
     * @return
     */
    private boolean isPatternValid(Pattern regexPattern, String text) {
        return regexPattern.matcher(text).matches();
    }
}
