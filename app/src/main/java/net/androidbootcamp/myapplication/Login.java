package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.parse.FindCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class Login extends AppCompatActivity {
    EditText username_input;
    EditText password_input;
    Button signIn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_register);

      /*Parse.enableLocalDatastore(this);
       Parse.initialize(new Parse.Configuration.Builder(this)
               .applicationId("mynewapp") // should correspond to APP_ID env variable
               .clientKey("oreo")  // set explicitly unless clientKey is explicitly configured on Parse server
               .server("https://tester-20.herokuapp.com/parse").build());*/

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("tishauna-instagram-codepath") // should correspond to APP_ID env variable
                .clientKey(null)  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://tishauna-instagram-codepath.herokuapp.com/parse/").enableLocalDataStore().build());

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
              query.whereEqualTo("password", passwordResult);

              query.findInBackground(new FindCallback<ParseObject>() {
                  Intent inToMain = new Intent(Login.this, nav.class);

                   public void done(List<ParseObject> object, ParseException e) {
                       if (e == null) {
                         //  Log.d("users","Retrieved " + object.size() + " users");
                         //  e.printStackTrace();

                           if(object.size() == 0)
                           {
                               Toast.makeText(Login.this, "Invalid user credentials", Toast.LENGTH_LONG).show();
                           }
                           else
                               {
                                   startActivity(inToMain);
                               }
                       }

                       else {
                             //   Log.d("users", "Error: " + e.getMessage());
                            }
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
                                        Vendor_Items.setVendorName(usernameResult);
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
