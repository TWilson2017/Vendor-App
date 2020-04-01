package net.androidbootcamp.myapplication;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Store")
public class Store extends ParseObject {
    public static final String STORE_ID = "sto_id";
    public static final String STORE_STATE = "sto_state";

    public Store() {
        super();
    }

    public String getStoreID() {
        return getObjectId();
    }//end getStoreID


}
