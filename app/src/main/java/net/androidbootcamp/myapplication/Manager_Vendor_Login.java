package net.androidbootcamp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Manager_Vendor_Login extends AppCompatActivity {
    EditText username_input;
    EditText password_input;
    Button signIn_button;
    String vendorType = "Vendor";
    String managerType = "Store";
    String managerPasswordType = "StoreUser";
    String loginType;
    ParseQuery<ParseObject> query2 = ParseQuery.getQuery(managerPasswordType);
    boolean wrongCred = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_register);

        Intent answer = getIntent();
        loginType = answer.getStringExtra("type");

        if (loginType.equals(vendorType)) {
            this.loginType = vendorType;
        } else if (loginType.equals(managerType)) {
            this.loginType = managerType;
        }
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

                if (loginType.equals(vendorType)) {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery(loginType);

                    query.whereEqualTo("username", usernameResult);
                    query.whereEqualTo("password", passwordResult);

                    query.findInBackground(new FindCallback<ParseObject>() {
                        // TODO: change this to show all stores
                        Intent inToMain = new Intent(Manager_Vendor_Login.this, nav.class);

                        public void done(List<ParseObject> object, ParseException e) {
                            if (e == null) {
                                if (object.size() == 0) {
                                    Toast.makeText(Manager_Vendor_Login.this, "Invalid user credentials", Toast.LENGTH_LONG).show();
                                } else {
                                    startActivity(inToMain);
                                }
                            } else {

                            }
                        }
                    });
                } else if (loginType.equals(managerType)) {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery(loginType);

                    query.whereEqualTo("sto_email", usernameResult);
                    query2.whereEqualTo("stu_password", passwordResult);

                    query.findInBackground(new FindCallback<ParseObject>() {
                        Intent inToMain = new Intent(Manager_Vendor_Login.this, nav.class);

                        public void done(List<ParseObject> object, ParseException e) {
                            if (e == null) {
                                if (object.size() == 0) {
                                    Toast.makeText(Manager_Vendor_Login.this, "Invalid user credentials", Toast.LENGTH_LONG).show();
                                    wrongCred = true;
                                } else {
                                    if (wrongCred == false) {
                                        query2.findInBackground(new FindCallback<ParseObject>() {
                                            Intent inToMain = new Intent(Manager_Vendor_Login.this, nav.class);

                                            public void done(List<ParseObject> object, ParseException e) {
                                                if (e == null) {
                                                    if (object.size() == 0) {
                                                        Toast.makeText(Manager_Vendor_Login.this, "Invalid user credentials", Toast.LENGTH_LONG).show();
                                                    } else {
                                                        startActivity(inToMain);
                                                    }
                                                } else {
                                                }
                                            }
                                        });
                                    }
                                }
                            } else {

                            }
                        }
                    });
                }
            }
        });
    }
}
