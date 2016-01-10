package dell.moneymatters;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class Signup extends AppCompatActivity {

    EditText firstName, lastName, country, email, displayName, password;
    Button signup;

    /* A reference to the Firebase */
    private Firebase mFirebaseRef;
    private ProgressDialog mSignupProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));

        displayName = (EditText) findViewById(R.id.etDisplayName);
        firstName = (EditText) findViewById(R.id.etFirstName);
        lastName = (EditText) findViewById(R.id.etLastName);
        email = (EditText) findViewById(R.id.etSignupEmail);
        country = (EditText) findViewById(R.id.etCountry);
        password = (EditText) findViewById(R.id.etSignupPassword);

        signup = (Button) findViewById(R.id.bSignup);

        /* Setup the progress dialog that is displayed later when authenticating with Firebase */
        mSignupProgressDialog = new ProgressDialog(this);
        mSignupProgressDialog.setTitle("Loading");
        mSignupProgressDialog.setMessage("Signingup with Firebase...");
        mSignupProgressDialog.setCancelable(false);

        // TODO : Remove password, and set a random password and send a password reset mail programatically for email verification

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkForEmptyFields()) {
                    return;
                }
                mSignupProgressDialog.show();
                mFirebaseRef.createUser(email.getText().toString(), signup.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {

                    @Override
                    public void onSuccess(Map<String, Object> stringObjectMap) {
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("uid", (String)stringObjectMap.get("uid")).commit();
                        Toast.makeText(getApplicationContext(), (String)stringObjectMap.get("uid"), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Toast.makeText(getApplicationContext(), firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                mFirebaseRef.resetPassword(email.getText().toString(), new Firebase.ResultHandler() {
                    @Override
                    public void onSuccess() {
                        // TODO : Tell user to see his mail for password
                        mSignupProgressDialog.dismiss();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Toast.makeText(getApplicationContext(), firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        mSignupProgressDialog.dismiss();
                    }
                });
            }
        });

    }

    private void showEmptyFieldToast(String fieldName) {
        Toast.makeText(getApplicationContext(), fieldName + " is empty", Toast.LENGTH_SHORT).show();
    }

    private boolean checkForEmptyFields() {
        if (displayName.getText().toString().isEmpty()) {
            showEmptyFieldToast("Display name");
            return true;
        }
        if (firstName.getText().toString().isEmpty()) {
            showEmptyFieldToast("First name");
            return true;
        }
        if (lastName.getText().toString().isEmpty()) {
            showEmptyFieldToast("Last name");
            return true;
        }
        if (email.getText().toString().isEmpty()) {
            showEmptyFieldToast("Email");
            return true;
        }
        if (country.getText().toString().isEmpty()) {
            showEmptyFieldToast("Country");
            return true;
        }
        return false;
    }

}
