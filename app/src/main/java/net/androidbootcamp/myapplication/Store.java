package net.androidbootcamp.myapplication;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Store")
public class Store extends ParseObject {
    public static final String STORE_ID = "sto_id";
    public static final String STORE_STATE = "sto_state";
    public static final String STORE_CITY = "sto_city";
    public static final String STORE_EMAIL = "sto_email";
    public static final String STORE_ZIPCODE = "sto_zipcode";
    public static final String STORE_STREETADDRESS = "sto_street_address";
    public static final String STORE_PHONE = "sto_phone";
    public static final String VENDOR_ID = "ven_id";

    public Store() {
        super();
    }

    public String getStoreID() {
        return getObjectId();
    }//end getStoreID

    //add get/set storeID
    public ParseObject getvendorId() {
        return getParseObject(VENDOR_ID);
    }

    public void setvendorId(ParseObject vendorId) {
        put(VENDOR_ID, vendorId);
    }

    public ParseObject getstoreId() {
        return getParseObject(STORE_ID);
    }

    public void setstoreId(ParseObject storeId) {
        put(STORE_ID, storeId);
    }

    public String getStoreState() {
        return getString(STORE_STATE);
    }

    public void setStoreState(String name) {
        put(STORE_STATE, name);
    }

    public String getStoreCity() {
        return getString(STORE_CITY);
    }

    public void setStoreCity(String name) {
        put(STORE_CITY, name);
    }

    public String getStoreEmail() {
        return getString(STORE_EMAIL);
    }

    public void setStoreEmail(String name) {
        put(STORE_EMAIL, name);
    }

    public int getStoresZipcode() {
        return getInt(STORE_ZIPCODE);
    }

    public void setStoreZipcode(int number) {
        put(STORE_ZIPCODE, number);
    }

    public String getStoreStreetaddress() {
        return getString(STORE_STREETADDRESS);
    }

    public void setStoreStreetaddress(String name) {
        put(STORE_STREETADDRESS, name);
    }

    public int getStorePhone() {
        return getInt(STORE_PHONE);
    }

    public void setStorePhone(int number) {
        put(STORE_PHONE, number);
    }

    public String getKeyObjID() {
        return getObjectId();
    }

}
