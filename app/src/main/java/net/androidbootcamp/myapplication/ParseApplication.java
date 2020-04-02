package net.androidbootcamp.myapplication;

import android.app.Application;

import com.parse.ParseInstallation;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //use a new port number
//parse-dashboard --appId mynewapp --masterKey oreo --serverURL "https://tester-20.herokuapp.com/parse" --port 9591 --dev
        //https://pixel-nancy-9591.codio.io

        ParseObject.registerSubclass(Product.class);
        /***Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
         .applicationId("") // should correspond to APP_ID env variable
         .clientKey(null)  // set explicitly unless clientKey is explicitly configured on Parse server
         .server("").enableLocalDataStore().build());***/
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
