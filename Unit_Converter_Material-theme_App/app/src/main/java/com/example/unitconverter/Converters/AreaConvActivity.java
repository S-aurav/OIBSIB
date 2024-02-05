package com.example.unitconverter.Converters;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.unitconverter.Convert;
import com.example.unitconverter.R;
import com.example.unitconverter.databinding.ActivityAreaConverterBinding;


import java.util.ArrayList;
import java.util.List;

public class AreaConvActivity extends AppCompatActivity {
    private List<String> lengthList;

    double d = 0.00;
    private TextWatcher textWatcher;
    public ActivityAreaConverterBinding binding;

    Convert convert = new Convert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAreaConverterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Initialising the length list.
        lengthList = new ArrayList<>();
        lengthList.add("sq. cm");
        lengthList.add("sq. inch");
        lengthList.add("sq. foot");
        lengthList.add("sq. m");
        lengthList.add("sq. km");
        lengthList.add("acre");
        lengthList.add("hectare");
        lengthList.add("sq. yard");


        binding.fromSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.punyetgrad_array_upper, lengthList));
        binding.toSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.punyetgrad_array_lower, lengthList));
        binding.toSpin.setSelection(1);

        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                switch(binding.toSpin.getSelectedItemPosition()){
//
//                }
                Log.d("LOOOL", String.valueOf(binding.toSpin.getSelectedItemPosition()));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (binding.fromText.getText().hashCode() == s.hashCode()) {
                    binding.toText.removeTextChangedListener(textWatcher);
                    switch (binding.fromSpin.getSelectedItemPosition()) {
                        case 0:
                            sqcmConversion(true);
                            break;
                        case 1:
                            sqinchConversion(true);
                            break;
                        case 2:
                            sqfootConversion(true);
                            break;
                        case 3:
                            sqmConversion(true);
                            break;
                        case 4:
                            sqkmConversion(true);
                            break;
                        case 5:
                            acreConversion(true);
                            break;
                        case 6:
                            hectareConversion(true);
                            break;
                        case 7:
                            sqyardConversion(true);
                            break;
                    }
                    if (binding.fromText.getText().toString().isEmpty()) {
                        binding.toText.setText("");
                    }

                    binding.toText.addTextChangedListener(textWatcher);
                } else if (binding.toText.getText().hashCode() == s.hashCode()) {
                    binding.fromText.removeTextChangedListener(textWatcher);
                    switch (binding.fromSpin.getSelectedItemPosition()) {
                        case 0:
                            sqcmConversion(false);
                            break;
                        case 1:
                            sqinchConversion(false);
                            break;
                        case 2:
                            sqfootConversion(false);
                            break;
                        case 3:
                            sqmConversion(false);
                            break;
                        case 4:
                            sqkmConversion(false);
                            break;
                        case 5:
                            acreConversion(false);
                            break;
                        case 6:
                            hectareConversion(false);
                            break;
                        case 7:
                            sqyardConversion(false);
                            break;
                    }
                    if (binding.toText.getText().toString().isEmpty()) {
                        binding.fromText.setText("");
                    }
                    binding.fromText.addTextChangedListener(textWatcher);
                }

                //Changing text size if no. of character > 7
                if (binding.fromText.getText().length() > 7) {
                    binding.fromText.setTextSize(24f);
                } else {
                    binding.fromText.setTextSize(35f);
                }

                if (binding.toText.getText().length() > 7) {
                    binding.toText.setTextSize(24f);
                } else {
                    binding.toText.setTextSize(35f);
                }


            }
        };

        binding.fromSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (binding.fromSpin.getSelectedItemPosition()) {
                    case 0:
                        removingWatcher();
                        sqcmConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        sqinchConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        sqfootConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        sqmConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        sqkmConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        acreConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        hectareConversion(true);
                        addingWatcher();
                        break;
                    case 7:
                        removingWatcher();
                        sqyardConversion(true);
                        addingWatcher();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        binding.toSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (binding.fromSpin.getSelectedItemPosition()) {
                    case 0:
                        removingWatcher();
                        sqcmConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        sqinchConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        sqfootConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        sqmConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        sqkmConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        acreConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        hectareConversion(true);
                        addingWatcher();
                        break;
                    case 7:
                        removingWatcher();
                        sqyardConversion(true);
                        addingWatcher();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.fromText.addTextChangedListener(textWatcher);
        binding.toText.addTextChangedListener(textWatcher);


    }

    private void addingWatcher() {
        binding.fromText.addTextChangedListener(textWatcher);
        binding.toText.addTextChangedListener(textWatcher);
    }

    private void removingWatcher() {
        binding.fromText.removeTextChangedListener(textWatcher);
        binding.toText.removeTextChangedListener(textWatcher);
    }

    private void sqcmConversion(boolean flag) {

        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.sqcmTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.sqcmTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.sqcmTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.sqcmTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.sqcmTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.sqcmToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.sqcmTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.sqcmTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }


            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqcm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }



    private void sqinchConversion ( boolean flag){
        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.sqinchTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.sqinchTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.sqinchTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.sqinchTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.sqinchTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.sqinchToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.sqinchTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.sqinchTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }

    private void sqfootConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.sqfootTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.sqfootTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.sqfootTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.sqfootTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.sqfootTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.sqfootToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.sqfootTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.sqfootTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqfoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void sqmConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.sqmTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.sqmTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.sqmTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.sqmTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.sqmTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.sqmToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.sqmTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.sqmTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void sqkmConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.sqkmTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.sqkmTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.sqkmTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.sqkmTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.sqkmTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.sqkmToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.sqkmTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.sqkmTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqkm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void acreConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.acreTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.acreTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.acreTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.acreTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.acreTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.acreToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.acreTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.acreTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }
            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardToacre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void hectareConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.hectareTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.hectareTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.hectareTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.hectareTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.hectareTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.hectareToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.hectareTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.hectareTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }
            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTohectare(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void sqyardConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.sqyardTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqcm.setText("sq. cm :: " + String.format("%.4f", d));
                d = convert.sqyardTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqinch.setText("sq. inch :: " + String.format("%.4f", d));
                d = convert.sqyardTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqfoot.setText("sq. foot :: " + String.format("%.4f", d));
                d = convert.sqyardTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqm.setText("sq. m :: " + String.format("%.4f", d));
                d = convert.sqyardTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqkm.setText("sq. km :: " + String.format("%.4f", d));
                d = convert.sqyardToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.acre.setText("acre :: " + String.format("%.4f", d));
                d = convert.sqyardTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.hectare.setText("hectare :: " + String.format("%.4f", d));
                d = convert.sqyardTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.sqyard.setText("sq. yard :: " + String.format("%.4f", d));

            } else {
                binding.sqcm.setText("sq. cm :: ");
                binding.sqinch.setText("sq. inch :: ");
                binding.sqfoot.setText("sq. foot :: ");
                binding.sqm.setText("sq. m :: ");
                binding.sqkm.setText("sq. km :: ");
                binding.acre.setText("acre :: ");
                binding.hectare.setText("hectare :: ");
                binding.sqyard.setText("sq. yard :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqcm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqfoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqkm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardToacre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTohectare(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqcmTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqinchTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqfootTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqmTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqkmTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.acreTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.hectareTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.sqyardTosqyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

}
