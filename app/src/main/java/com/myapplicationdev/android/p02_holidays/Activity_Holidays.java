package com.myapplicationdev.android.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity_Holidays extends AppCompatActivity {

    ListView lv;
    TextView tvHol;
    ArrayList<Holiday> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_holidays);

        lv = (ListView) this.findViewById(R.id.lvHolidays);
        tvHol = (TextView) this.findViewById(R.id.textView);

        al = new ArrayList<Holiday>();
        al.add(new Holiday("New Year Day", "1 Jan"));
        al.add(new Holiday("Labour Day", "1 May"));

        Intent i = getIntent();
        String sec = i.getStringExtra(Intent.EXTRA_TEXT);
        tvHol.setText(sec);

        aa = new HolidayAdapter(this, R.layout.row, al);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Holiday selectedItem = al.get(position);

                Toast.makeText(Activity_Holidays.this, selectedItem.getHol() + ": " + selectedItem.getDate(), Toast.LENGTH_LONG).show();


            }
        });
        lv.setAdapter(aa);
    }


}