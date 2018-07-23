package com.mahmoudreda.ustcafeteriaowner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class order_details extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("comment");
    DatabaseReference myRef_1 = database.getReference("customer_name");
    DatabaseReference myRef_2 = database.getReference("customer_id");
    DatabaseReference myRef_3 = database.getReference("customer_phone");
    DatabaseReference myRef_4 = database.getReference("message");
    DatabaseReference myRef_5 = database.getReference("price");
    DatabaseReference myRef_6 = database.getReference("number_message");

    private String TAG = "firebase";
    TextView MainText;
    TextView name;
    TextView id;
    TextView phone;
    TextView text_name;
    TextView text_price;
    TextView text_number;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        // initialize text view < and work with Firebase
        MainText = findViewById(R.id.comment);
        name = findViewById(R.id.gust_name);
        id = findViewById(R.id.gust_id);
        phone = findViewById(R.id.phone_number);
        text_name = findViewById(R.id.item_name);
        text_price = findViewById(R.id.item_price);
        text_number = findViewById(R.id.number_item);

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                MainText.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myRef_1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                name.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myRef_2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                id.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        myRef_3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                phone.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef_4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                text_name.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef_5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                text_price.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef_6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                text_number.setText(value);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        ArrayList<list_item_order> Items = new ArrayList<>();
        MyCustomAdapter my_adapter = new MyCustomAdapter(Items);
        for (int i = 0; i <= 0; i++) {
            Items.add(new list_item_order("" + text_name, "" + text_number, "" +text_price));
        }
        ListView Ls = findViewById(R.id.list_view2);
        Ls.setAdapter(my_adapter);
    }

    class MyCustomAdapter extends BaseAdapter {
        ArrayList<list_item_order> Items = new ArrayList<>();

        MyCustomAdapter(ArrayList<list_item_order> Items) {
            this.Items = Items;
        }

        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public Object getItem(int position) {

            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater linflater = getLayoutInflater();
            View view1 = linflater.inflate(R.layout.coustmerlayout_order_details, null);
            TextView textname = view1.findViewById(R.id.item_name);
            TextView textnumber = view1.findViewById(R.id.number_item);
            TextView textprice = view1.findViewById(R.id.item_price);
            textname.setText(Items.get(i).item_name);
            textnumber.setText(Items.get(i).number_item);
            textprice.setText(Items.get(i).item_price);
            return view1;
        }
    }
}