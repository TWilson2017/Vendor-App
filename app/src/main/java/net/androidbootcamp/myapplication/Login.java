package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText username_input;
    EditText password_input;
    Button signIn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_register);

        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("tishauna-instagram-codepath") // should correspond to APP_ID env variable
                .clientKey(null)  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://tishauna-instagram-codepath.herokuapp.com/parse/").build());

//----------------------------------------------------
// User Sign in Input
//----------------------------------------------------
        username_input = findViewById(R.id.username_input);
        password_input = findViewById(R.id.password_input);

//--------------------------------------------------
// Sign in button
//---------------------------------------------------
        signIn_button = findViewById(R.id.signin_button3);
        signIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernameResult = username_input.getText().toString();
                final String passwordResult = password_input.getText().toString();

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Vendor");
                query.whereEqualTo("username", usernameResult);
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (object == null) {
                            Toast.makeText(Login.this, "Username is incorrect", Toast.LENGTH_LONG).show();
                        } else {
                            ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Vendor");
                            query2.whereEqualTo("password", passwordResult);
                            query2.getFirstInBackground(new GetCallback<ParseObject>() {
                                public void done(ParseObject object, ParseException e) {
                                    if (object == null) {
                                        Toast.makeText(Login.this, "Password is incorrect", Toast.LENGTH_LONG).show();
                                    } else {
                                        Intent inToMain = new Intent(Login.this, Vendor_Items.class);
                                        startActivity(inToMain);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}
