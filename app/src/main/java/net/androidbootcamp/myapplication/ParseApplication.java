package net.androidbootcamp.myapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//parse-dashboard --appId mynewapp --masterKey oreo --serverURL "https://tester-20.herokuapp.com/parse" --port 9591 --dev
        //https://pixel-nancy-9591.codio.io

        ParseObject.registerSubclass(Product.class);

        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("cjones-parse-server") // should correspond to APP_ID env variable
                .clientKey("Grayson2015")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://parse-server-example-cjones.herokuapp.com/parse").build());

        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
