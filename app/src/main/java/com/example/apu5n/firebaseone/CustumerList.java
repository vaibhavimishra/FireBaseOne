package com.example.apu5n.firebaseone;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apu5n on 15-04-2018.
 */

public class CustumerList extends ArrayAdapter<CustumerDetails> {

    private Activity context;
    private List<CustumerDetails> custumerDetailsList;

    public CustumerList(Activity context, List<CustumerDetails> custumerDetailsList){
         super(context,R.layout.list_layout,custumerDetailsList);
         this.context = context;
         this.custumerDetailsList = custumerDetailsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView tv_address = (TextView) listViewItem.findViewById(R.id.tv_address);
        TextView tv_name = (TextView) listViewItem.findViewById(R.id.tv_name);
        TextView tv_puja_id = (TextView) listViewItem.findViewById(R.id.tv_puja_id);
        TextView tv_mobile_number = (TextView) listViewItem.findViewById(R.id.tv_mobile_number);

        CustumerDetails custumerDetails = custumerDetailsList.get(position);

        tv_address.setText(custumerDetails.cust_address);
        tv_name.setText(custumerDetails.cust_name);
        tv_puja_id.setText(custumerDetails.puja_id);
        tv_mobile_number.setText(custumerDetails.cust_mobile_number);

        return listViewItem;


    }


}
