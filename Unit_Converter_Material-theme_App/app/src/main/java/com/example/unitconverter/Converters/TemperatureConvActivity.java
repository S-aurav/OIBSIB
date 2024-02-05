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
import com.example.unitconverter.databinding.ActivityTemperatureConverterBinding;

import java.util.List;
import java.util.ArrayList;


public class TemperatureConvActivity extends AppCompatActivity {
    private List<String> lengthList;
    private AppBarConfiguration appBarConfiguration;
    double d = 0.00;
    private TextWatcher textWatcher;
    public ActivityTemperatureConverterBinding binding;
    Convert convert = new Convert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTemperatureConverterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //Initialising the length list.
        lengthList = new ArrayList<>();
        lengthList.add("°K");
        lengthList.add("°F");
        lengthList.add("°C");


        binding.fromSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.sweetmorning_array_upper, lengthList));
        binding.toSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.sweetmorning_array_lower, lengthList));
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
                            kConversion(true);
                            break;
                        case 1:
                            fConversion(true);
                            break;
                        case 2:
                            cConversion(true);
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
                            kConversion(false);
                            break;
                        case 1:
                            fConversion(false);
                            break;
                        case 2:
                            cConversion(false);
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
                        kConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        fConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        cConversion(true);
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
                        kConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        fConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        cConversion(true);
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

    private void kConversion(boolean flag) {

        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.kelvinTokelvin(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.k.setText("°K :: " + String.format("%.4f", d));
                d = convert.kelTofah(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.f.setText("°F :: " + String.format("%.4f", d));
                d = convert.kelTocel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.c.setText("°C :: " + String.format("%.4f", d));


            } else {
                binding.k.setText("°K :: ");
                binding.f.setText("°F :: ");
                binding.c.setText("°C :: ");

            }


            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kelvinTokelvin(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kelTofah(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kelTocel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kelvinTokelvin(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.fahTokel(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.celTokel(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

            }
        }
    }

    private void fConversion ( boolean flag){
        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.fahTokel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.k.setText("°K :: " + String.format("%.4f", d));
                d = convert.fahTofah(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.f.setText("°F :: " + String.format("%.4f", d));
                d = convert.fahTocel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.c.setText("°C :: " + String.format("%.4f", d));


            } else {
                binding.k.setText("°K :: ");
                binding.f.setText("°F :: ");
                binding.c.setText("°C :: ");

            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.fahTokel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.fahTofah(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.fahTocel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kelTofah(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.fahTofah(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.celTofah(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

            }
        }
    }

    private void cConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.celTokel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.k.setText("°K :: " + String.format("%.4f", d));
                d = convert.celTofah(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.f.setText("°F :: " + String.format("%.4f", d));
                d = convert.celTocel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.c.setText("°C :: " + String.format("%.4f", d));

            } else {
                binding.k.setText("°K :: ");
                binding.f.setText("°F :: ");
                binding.c.setText("°C :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.celTokel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.celTofah(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.celTocel(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kelTocel(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.fahTocel(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.celTocel(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

            }
        }

    }
}