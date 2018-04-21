package com.example.apu5n.firebaseone;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp1;
    ArrayAdapter<String> spinnerArrayAdapter;
    List<String> categories;
    Integer Total_Cost[] = {500, 600, 700};
    Integer i;
    EditText name, address, phone;
    TextView Total_Cost_is;
    Button pao;

    DatabaseReference databaseCustumerDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseCustumerDetails = FirebaseDatabase.
                getInstance().getReference().child("CustumerDetails");


      /*  setContentView(R.layout.activity_main);
        listViewCustumer = (ListView) findViewById(R.id.ls_listViewCustumer);
        custumerDetailsList = new ArrayList<>();
      */
        sp1 = (Spinner) (findViewById(R.id.PAO_Spinner_List));
        // Spinner click listener
        sp1.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        categories = new ArrayList<String>();
        categories.add("Adhik Mass");
        categories.add("Satyanarayan");
        categories.add("Diwali Puja");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        sp1.setAdapter(dataAdapter);

        name = (EditText) findViewById(R.id.Name);
        address = (EditText) findViewById(R.id.Address);
        phone = (EditText) findViewById(R.id.Phone);
        pao = (Button) findViewById(R.id.PlaceTheOrder);
        pao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               custumerDeatils();
            }
        });


    }

    public void custumerDeatils(){

        if (name.getText().toString().length() == 0) {
            name.setError("This field is required!");
            name.requestFocus();
        } else if (address.getText().toString().length() == 0) {
            address.setError("This field is required!");
            address.requestFocus();
        } else if (phone.getText().toString().length() == 0) {
            phone.setError("This field is required!");
            phone.requestFocus();
        } else if (phone.getText().toString().length() < 10) {
            phone.setError("Mobile number should be of 10 digits");
            phone.requestFocus();
        } else {
            String puja_id = sp1.getSelectedItem().toString();
            String cust_name = name.getText().toString();
            String cust_address = address.getText().toString();
            String cust_mobile_number = phone.getText().toString();
            String id = databaseCustumerDetails.push().getKey();
            CustumerDetails cd = new CustumerDetails(id,cust_name,cust_address,cust_mobile_number,puja_id);
            databaseCustumerDetails.child(id).setValue(cd);
            startActivity(new Intent(getApplication(), Thank_You.class));
        }



    }



    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

        Total_Cost_is = (TextView) findViewById(R.id.TotalCosts);
        String Result, r1 = "";

        String value = sp1.getSelectedItem().toString();

        for (i = 0; i < categories.size(); i++) {
            if (value == categories.get(i)) {
                r1 = Total_Cost[i].toString();
            }
        }

        Result = "You need to pay Rs." + r1;
        Total_Cost_is.setText(Result);
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}





