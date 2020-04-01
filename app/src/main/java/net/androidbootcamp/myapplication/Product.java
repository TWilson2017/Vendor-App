package net.androidbootcamp.myapplication;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Product")
public class Product extends ParseObject {
    public static final String PRODUCT_NAME = "pro_name";
    public static final String PRODUCT_QUANTITY = "pro_quantity";
    public static final String PRODUCT_PRICE = "pro_price";
    public static final String PRODUCT_IMG = "img";
    public static final String PRODUCT_TYPE = "pro_type";
    public static final String SKU_NUM = "pro_sku_num";
    public static final String BRAND_ID = "bra_id";

    public Product() {
        super();
    }

//add get/set storeID

    public ParseObject getbrandId() {
        return getParseObject(BRAND_ID);
    }

    public void setBrandId(ParseObject brandId) {
        put(BRAND_ID, brandId);
    }
    public String getpro_name() {
        return getString(PRODUCT_NAME);
    }

    public void setpro_name(String name) {
        put(PRODUCT_NAME, name);
    }

    public int getpro_quantity() {
        return getInt(PRODUCT_QUANTITY);
    }

    public void setpro_quantity(int quantity) {
        put(PRODUCT_QUANTITY, quantity);
    }

    public double getpro_price() {
        return getDouble(PRODUCT_PRICE);
    }

    public void setpro_price(double price) {
        put(PRODUCT_PRICE, price);
    }

    public ParseFile getimg() {
        return getParseFile(PRODUCT_IMG);
    }

    public void setimg(ParseFile image) {
        put(PRODUCT_IMG, image);
    }

    public String getpro_type() {
        return getString(PRODUCT_TYPE);
    }

    public void setpro_type(String type) {
        put(PRODUCT_TYPE, type);
    }

    public int getsku_num() {
        return getInt(SKU_NUM);
    }

    public void setsku_num(int sku) {
        put(SKU_NUM, sku);
    }

    public String getKeyObjID() {
        return getObjectId();
    }


}//end inventory class
