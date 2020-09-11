package com.example.property_database;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    ArrayAdapter<String> dataAdapter;
    ArrayAdapter<String> dataAdapter2;
    ArrayAdapter<String> dataAdapter3;
    Spinner spinner,spinner2,spinner3;
    ArrayList<String> categories,categories2,categories3;
    Button details,otherentires;
    EditText name,location,plotdimension;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categories = new ArrayList<String>();
        categories2 = new ArrayList<String>();
        categories3 = new ArrayList<String>();
        categories.add("SELLLER");
        categories.add("DEALER");
        categories.add("PROJECT NAME");
        categories2.add("PLOT");
        categories2.add("HOUSE");
        categories3.add("DUPLEX");
        categories3.add("SINGLE");


        // Spinner element
         spinner = (Spinner) findViewById(R.id.spinner1);
         spinner2 = (Spinner) findViewById(R.id.spinner2);
         spinner3 = (Spinner) findViewById(R.id.spinner3);
         details=(Button)findViewById(R.id.details);
         otherentires=(Button)findViewById(R.id.otherentries);
         name=(EditText)findViewById(R.id.txtName);
         location=(EditText)findViewById(R.id.location);
        plotdimension=(EditText)findViewById(R.id.plotdimension);






        // Spinner click listener
       spinner.setOnItemSelectedListener(this);
       spinner2.setOnItemSelectedListener(this);
       spinner3.setOnItemSelectedListener(this);




        // Spinner Drop down elements


        // Creating adapter for spinner
      dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);


        // Drop down layout style - list view with radio button
       dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);
        spinner3.setAdapter(dataAdapter3);


otherentires.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(name.length()==0 || location.length()==0 || plotdimension.length()==0)
        {
            Toast.makeText(getApplicationContext(),
                    "Mandatory fields",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(i);
        }
    }
});


    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            final boolean house;
        if (spinner2.getSelectedItem().toString().equals("HOUSE")){
            house = true;
           plotdimension.setVisibility(View.GONE);
           spinner3.setVisibility(View.VISIBLE);
           plotdimension.setText("");

        }

        else { house = false;
            spinner3.setVisibility(View.GONE);
            spinner3.setAdapter(dataAdapter3);
            plotdimension.setVisibility(View.VISIBLE);

        }


    }




    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}