package com.mahmoudreda.ustcafeteriaowner;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class allorder extends AppCompatActivity {

    ListView listView;

    ArrayList<String> list = new ArrayList<>();
    DatabaseReference databaseReference;
    MyCustomAdapter my_adapter1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allorder);


        listView = findViewById(R.id.list_view);
        databaseReference = FirebaseDatabase
                .getInstance().getReferenceFromUrl("https://ustcoffe.firebaseio.com/list");


        my_adapter1 = new MyCustomAdapter(list);
        listView.setAdapter(my_adapter1);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                list.add(value);
                my_adapter1.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                list.remove(value);
                my_adapter1.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        //

        // for (int i = 0; i <=list.size(); i++) {
        //   Items.add(new list_item_all_order
        //            ("sfadsf","name","name","name","ad"));
        //}


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Intent i = new Intent(getApplicationContext(), order_details.class);
                //startActivity(i);
                Toast.makeText(allorder.this, "order " + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    class MyCustomAdapter extends BaseAdapter {
        ArrayList<String> Items = new ArrayList<>();

        MyCustomAdapter(ArrayList<String> Items) {
            this.Items = Items;
        }

        @Override
        public int getCount() {
            return Items.size();
        }


        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int t, View view, ViewGroup viewGroup) {
            LayoutInflater linflater = getLayoutInflater();
            @SuppressLint("ViewHolder") View view1 = linflater.inflate(R.layout.coustmerlayout_all_order, null);
            TextView namegust = view1.findViewById(R.id.gust_name);
            TextView idgust = view1.findViewById(R.id.gust_id);
            TextView phonenumber = view1.findViewById(R.id.phone_number);
            TextView textname = view1.findViewById(R.id.item_name);
            TextView textprice = view1.findViewById(R.id.item_price);

            namegust.setText(Items.get(0));
            idgust.setText(Items.get(1));
            textname.setText(Items.get(2));
            textprice.setText(Items.get(3));
            phonenumber.setText(Items.get(4));
            return view1;
        }
    }
}