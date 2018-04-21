package com.example.apu5n.firebaseone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Thank_You extends MainActivity {


    ListView listViewCustumer;
   // DatabaseReference databaseCustumerDetails;
    List<CustumerDetails> custumerDetailsList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank__you);
        listViewCustumer = (ListView) findViewById(R.id.ls_listViewCustumer);
        custumerDetailsList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseCustumerDetails.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                custumerDetailsList.clear();
                for(DataSnapshot custumerDetailSnapshot: dataSnapshot.getChildren()){
                    CustumerDetails custumerDetails = custumerDetailSnapshot.getValue(CustumerDetails.class);
                    custumerDetailsList.add(custumerDetails);
                }
                CustumerList adapter = new CustumerList(Thank_You.this,custumerDetailsList);
                listViewCustumer.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
