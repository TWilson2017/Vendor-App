package net.androidbootcamp.myapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Product.class);

        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("mynewapp") // should correspond to APP_ID env variable
                .clientKey("oreo")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://tester-20.herokuapp.com/parse").build());

        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
