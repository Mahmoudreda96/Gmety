package com.mahmoudreda.ustCoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class order extends AppCompatActivity {

// Read from the database

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");
    DatabaseReference myRef_1 = database.getReference("price");

    Button confirme ;
    private String TAG = "firebaseCrash";
    TextView text_name;
    TextView text_price;
    ListView listView ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // initialize text view < and work with Firebase
        text_name = findViewById(R.id.item_name);
        text_price = findViewById(R.id.item_price);
        confirme = findViewById(R.id.confirm);


        myRef_1.addValueEventListener(new ValueEventListener() {
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

        myRef.addValueEventListener(new ValueEventListener() {
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

        confirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        listView = findViewById(R.id.list_view_order);
        ArrayList<list_Item_menu> Items = new ArrayList<>();
        for (int i = 0; i <= 0; i++) {
            Items.add(new list_Item_menu("" + text_name, "" + text_price));
        }


        order.MyCustomAdapter my_adapter = new order.MyCustomAdapter(Items);
        listView.setAdapter(my_adapter);
    }

    class MyCustomAdapter extends BaseAdapter {
        ArrayList<list_Item_menu> Items = new ArrayList<>();

        MyCustomAdapter(ArrayList<list_Item_menu> Items) {
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
        public View getView(int i, View View, ViewGroup viewGroup) {
            LayoutInflater linflater = getLayoutInflater();
            View view1 = linflater.inflate(R.layout.coustmerlayout_order, null);
            text_name = view1.findViewById(R.id.item_price);
            text_price = view1.findViewById(R.id.item_name);

            text_name.setText(Items.get(i).price);
            text_price.setText(Items.get(i).name);
            return view1;
        }
    }
}