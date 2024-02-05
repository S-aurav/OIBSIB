package com.example.unitconverter.Converters;

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
import com.example.unitconverter.databinding.ActivityVolumeConverterBinding;

import java.util.ArrayList;
import java.util.List;


public class VolumeConvActivity extends AppCompatActivity {
    private List<String> lengthList;
    private AppBarConfiguration appBarConfiguration;
    double d = 0.00;
    private TextWatcher textWatcher;
    public ActivityVolumeConverterBinding binding;
    Convert convert = new Convert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityVolumeConverterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());



        //Initialising the length list.
        lengthList = new ArrayList<>();
        lengthList.add("cu. cm");
        lengthList.add("cu. m");
        lengthList.add("ml");
        lengthList.add("litre");
        lengthList.add("US Pint");
        lengthList.add("US Gallon");


        binding.fromSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.bluegrad_array_upper, lengthList));
        binding.toSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.bluegrad_array_lower, lengthList));
        binding.fromSpin.setSelection(3);
        binding.toSpin.setSelection(2);

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
                            cucmConversion(true);
                            break;
                        case 1:
                            cumConversion(true);
                            break;
                        case 2:
                            mlConversion(true);
                            break;
                        case 3:
                            litreConversion(true);
                            break;
                        case 4:
                            pintConversion(true);
                            break;
                        case 5:
                            gallonConversion(true);
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
                            cucmConversion(false);
                            break;
                        case 1:
                            cumConversion(false);
                            break;
                        case 2:
                            mlConversion(false);
                            break;
                        case 3:
                            litreConversion(false);
                            break;
                        case 4:
                            pintConversion(false);
                            break;
                        case 5:
                            gallonConversion(false);
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
                        cucmConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        cumConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        mlConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        litreConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        pintConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        gallonConversion(true);
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
                        cucmConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        cumConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        mlConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        litreConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        pintConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        gallonConversion(true);
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

    private void cucmConversion(boolean flag) {

        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.cucmTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cucm.setText("cu. cm :: " + String.format("%.4f", d));
                d = convert.cucmTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cum.setText("cu. m :: " + String.format("%.4f", d));
                d = convert.cucmToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ml.setText("ml :: " + String.format("%.4f", d));
                d = convert.cucmTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.litre.setText("litre :: " + String.format("%.4f", d));
                d = convert.cucmTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pint.setText("US Pint :: " + String.format("%.4f", d));
                d = convert.cucmTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gallon.setText("US Gallon :: " + String.format("%.4f", d));

            } else {
                binding.cucm.setText("cu. cm :: ");
                binding.cum.setText("cu. m :: ");
                binding.ml.setText("ml :: ");
                binding.litre.setText("litre :: ");
                binding.pint.setText("US Pint :: ");
                binding.gallon.setText("US Gallon :: ");
            }


            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cucmTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cucmTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cucmToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cucmTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cucmTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cucmTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cucmTocucm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cumTocucm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mlTocucm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.litreTocucm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.pintTocucm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gallonTocucm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }



    private void cumConversion ( boolean flag){
        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.cumTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cucm.setText("cu. cm :: " + String.format("%.4f", d));
                d = convert.cumTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cum.setText("cu. m :: " + String.format("%.4f", d));
                d = convert.cumToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ml.setText("ml :: " + String.format("%.4f", d));
                d = convert.cumTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.litre.setText("litre :: " + String.format("%.4f", d));
                d = convert.cumTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pint.setText("US Pint :: " + String.format("%.4f", d));
                d = convert.cumTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gallon.setText("US Gallon :: " + String.format("%.4f", d));

            } else {
                binding.cucm.setText("cu. cm :: ");
                binding.cum.setText("cu. m :: ");
                binding.ml.setText("ml :: ");
                binding.litre.setText("litre :: ");
                binding.pint.setText("US Pint :: ");
                binding.gallon.setText("US Gallon :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cumTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cumTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cumToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cumTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cumTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cumTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cucmTocum(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cumTocum(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mlTocum(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.litreTocum(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.pintTocum(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gallonTocum(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }

    private void mlConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.mlTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cucm.setText("cu. cm :: " + String.format("%.4f", d));
                d = convert.mlTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cum.setText("cu. m :: " + String.format("%.4f", d));
                d = convert.mlToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ml.setText("ml :: " + String.format("%.4f", d));
                d = convert.mlTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.litre.setText("litre :: " + String.format("%.4f", d));
                d = convert.mlTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pint.setText("US Pint :: " + String.format("%.4f", d));
                d = convert.mlTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gallon.setText("US Gallon :: " + String.format("%.4f", d));

            } else {
                binding.cucm.setText("cu. cm :: ");
                binding.cum.setText("cu. m :: ");
                binding.ml.setText("ml :: ");
                binding.litre.setText("litre :: ");
                binding.pint.setText("US Pint :: ");
                binding.gallon.setText("US Gallon :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mlTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mlTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mlToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mlTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mlTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mlTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cucmToml(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cumToml(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mlToml(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.litreToml(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.pintToml(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gallonToml(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void litreConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.litreTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cucm.setText("cu. cm :: " + String.format("%.4f", d));
                d = convert.litreTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cum.setText("cu. m :: " + String.format("%.4f", d));
                d = convert.litreToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ml.setText("ml :: " + String.format("%.4f", d));
                d = convert.litreTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.litre.setText("litre :: " + String.format("%.4f", d));
                d = convert.litreTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pint.setText("US Pint :: " + String.format("%.4f", d));
                d = convert.litreTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gallon.setText("US Gallon :: " + String.format("%.4f", d));

            } else {
                binding.cucm.setText("cu. cm :: ");
                binding.cum.setText("cu. m :: ");
                binding.ml.setText("ml :: ");
                binding.litre.setText("litre :: ");
                binding.pint.setText("US Pint :: ");
                binding.gallon.setText("US Gallon :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.litreTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.litreTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.litreToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.litreTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.litreTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.litreTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cucmTolitre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cumTolitre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mlTolitre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.litreTolitre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.pintTolitre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gallonTolitre(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void pintConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.pintTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cucm.setText("cu. cm :: " + String.format("%.4f", d));
                d = convert.pintTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cum.setText("cu. m :: " + String.format("%.4f", d));
                d = convert.pintToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ml.setText("ml :: " + String.format("%.4f", d));
                d = convert.pintTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.litre.setText("litre :: " + String.format("%.4f", d));
                d = convert.pintTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pint.setText("US Pint :: " + String.format("%.4f", d));
                d = convert.pintTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gallon.setText("US Gallon :: " + String.format("%.4f", d));

            } else {
                binding.cucm.setText("cu. cm :: ");
                binding.cum.setText("cu. m :: ");
                binding.ml.setText("ml :: ");
                binding.litre.setText("litre :: ");
                binding.pint.setText("US Pint :: ");
                binding.gallon.setText("US Gallon :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.pintTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.pintTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.pintToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.pintTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.pintTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.pintTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cucmTopint(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cumTopint(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mlTopint(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.litreTopint(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.pintTopint(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gallonTopint(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void gallonConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.gallonTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cucm.setText("cu. cm :: " + String.format("%.4f", d));
                d = convert.gallonTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cum.setText("cu. m :: " + String.format("%.4f", d));
                d = convert.gallonToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ml.setText("ml :: " + String.format("%.4f", d));
                d = convert.gallonTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.litre.setText("litre :: " + String.format("%.4f", d));
                d = convert.gallonTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pint.setText("US Pint :: " + String.format("%.4f", d));
                d = convert.gallonTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gallon.setText("US Gallon :: " + String.format("%.4f", d));

            } else {
                binding.cucm.setText("cu. cm :: ");
                binding.cum.setText("cu. m :: ");
                binding.ml.setText("ml :: ");
                binding.litre.setText("litre :: ");
                binding.pint.setText("US Pint :: ");
                binding.gallon.setText("US Gallon :: ");
            }
            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gallonTocucm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gallonTocum(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gallonToml(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gallonTolitre(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gallonTopint(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gallonTogallon(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cucmTogallon(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cumTogallon(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mlTogallon(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.litreTogallon(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.pintTogallon(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gallonTogallon(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

            }
        }

    }
}