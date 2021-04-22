package com.myapplicationdev.android.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHoli;
    private TextView tvDate;
    private ImageView ivHoli;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHoli = (TextView) rowView.findViewById(R.id.tvHoli);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivHoli = (ImageView) rowView.findViewById(R.id.ivHoli);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHol = holiday.get(position);
        // Set the TextView to show the food

        tvHoli.setText(currentHol.getHol());
        tvDate.setText(currentHol.getDate());

        if(currentHol.getHol().equals("New Year Day")){
            ivHoli.setImageResource(R.drawable.new_year);
        }
        else {
            ivHoli.setImageResource(R.drawable.labour_day_1);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
