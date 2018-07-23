package com.mahmoudreda.ustcafeteriaowner;

import android.widget.TextView;

/**
 * Created by mahmoud reda on 30/01/2018.
 */

class list_item_all_order {


    public String gust_name;
    public String gust_id;
    public String phone_number;
    public String item_name;
    public String item_price;


    public list_item_all_order(String gust_name, String gust_id, String phone_number, String item_name, String item_price) {
        this.gust_name = gust_name;
        this.gust_id = gust_id;
        this.phone_number = phone_number;
        this.item_name = item_name;
        this.item_price = item_price;
    }
}