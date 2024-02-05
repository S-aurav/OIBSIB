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
import com.example.unitconverter.databinding.ActivityAreaConverterBinding;
import com.example.unitconverter.databinding.ActivityWeightConverterBinding;

import java.util.List;
import java.util.ArrayList;


public class WeightConvActivity extends AppCompatActivity {
    private List<String> lengthList;
    private AppBarConfiguration appBarConfiguration;
    double d = 0.00;
    private TextWatcher textWatcher;
    public ActivityWeightConverterBinding binding;
    Convert convert = new Convert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWeightConverterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());



        //Initialising the length list.
        lengthList = new ArrayList<>();
        lengthList.add("mg");
        lengthList.add("gm");
        lengthList.add("kg");
        lengthList.add("ton");
        lengthList.add("carat");
        lengthList.add("ounce");
        lengthList.add("pound");


        binding.fromSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.yellowgrad_array_upper, lengthList));
        binding.toSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.yellowgrad_array_lower, lengthList));
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
                            mgConversion(true);
                            break;
                        case 1:
                            gmConversion(true);
                            break;
                        case 2:
                            kgConversion(true);
                            break;
                        case 3:
                            tonConversion(true);
                            break;
                        case 4:
                            caratConversion(true);
                            break;
                        case 5:
                            ounceConversion(true);
                            break;
                        case 6:
                            poundConversion(true);
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
                            mgConversion(false);
                            break;
                        case 1:
                            gmConversion(false);
                            break;
                        case 2:
                            kgConversion(false);
                            break;
                        case 3:
                            tonConversion(false);
                            break;
                        case 4:
                            caratConversion(false);
                            break;
                        case 5:
                            ounceConversion(false);
                            break;
                        case 6:
                            poundConversion(false);
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
                        mgConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        gmConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        kgConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        tonConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        caratConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        ounceConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        poundConversion(true);
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
                        mgConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        gmConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        kgConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        tonConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        caratConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        ounceConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        poundConversion(true);
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

    private void mgConversion(boolean flag) {

        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.mgTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mg.setText("mg :: " + String.format("%.4f", d));
                d = convert.mgTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gm.setText("gm :: " + String.format("%.4f", d));
                d = convert.mgTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kg.setText("kg :: " + String.format("%.4f", d));
                d = convert.mgToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ton.setText("ton :: " + String.format("%.4f", d));
                d = convert.mgTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.carat.setText("carat :: " + String.format("%.4f", d));
                d = convert.mgToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ounce.setText("ounce :: " + String.format("%.4f", d));
                d = convert.mgTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pound.setText("pound :: " + String.format("%.4f", d));

            } else {
                binding.mg.setText("mg :: ");
                binding.gm.setText("gm :: ");
                binding.kg.setText("kg :: ");
                binding.ton.setText("ton :: ");
                binding.carat.setText("carat :: ");
                binding.ounce.setText("ounce :: ");
                binding.pound.setText("pound :: ");
            }


            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mgTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mgTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mgTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mgToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mgTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mgToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mgTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mgTomg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gmTomg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kgTomg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.tonTomg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.carratTomg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.ounceTomg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.poundTomg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }



    private void gmConversion ( boolean flag){
        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.gmTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mg.setText("mg :: " + String.format("%.4f", d));
                d = convert.gmTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gm.setText("gm :: " + String.format("%.4f", d));
                d = convert.gmTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kg.setText("kg :: " + String.format("%.4f", d));
                d = convert.gmToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ton.setText("ton :: " + String.format("%.4f", d));
                d = convert.gmTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.carat.setText("carat :: " + String.format("%.4f", d));
                d = convert.gmToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ounce.setText("ounce :: " + String.format("%.4f", d));
                d = convert.gmTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pound.setText("pound :: " + String.format("%.4f", d));

            } else {
                binding.mg.setText("mg :: ");
                binding.gm.setText("gm :: ");
                binding.kg.setText("kg :: ");
                binding.ton.setText("ton :: ");
                binding.carat.setText("carat :: ");
                binding.ounce.setText("ounce :: ");
                binding.pound.setText("pound :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gmTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gmTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gmTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gmToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gmTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gmToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.gmTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mgTogm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gmTogm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kgTogm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.tonTogm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.carratTogm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.ounceTogm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.poundTogm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }

    private void kgConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.kgTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mg.setText("mg :: " + String.format("%.4f", d));
                d = convert.kgTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gm.setText("gm :: " + String.format("%.4f", d));
                d = convert.kgTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kg.setText("kg :: " + String.format("%.4f", d));
                d = convert.kgToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ton.setText("ton :: " + String.format("%.4f", d));
                d = convert.kgTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.carat.setText("carat :: " + String.format("%.4f", d));
                d = convert.kgToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ounce.setText("ounce :: " + String.format("%.4f", d));
                d = convert.kgTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pound.setText("pound :: " + String.format("%.4f", d));

            } else {
                binding.mg.setText("mg :: ");
                binding.gm.setText("gm :: ");
                binding.kg.setText("kg :: ");
                binding.ton.setText("ton :: ");
                binding.carat.setText("carat :: ");
                binding.ounce.setText("ounce :: ");
                binding.pound.setText("pound :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kgTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kgTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kgTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kgToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kgTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kgToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kgTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mgTokg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gmTokg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kgTokg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.tonTokg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.carratTokg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.ounceTokg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.poundTokg(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void tonConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.tonTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mg.setText("mg :: " + String.format("%.4f", d));
                d = convert.tonTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gm.setText("gm :: " + String.format("%.4f", d));
                d = convert.tonTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kg.setText("kg :: " + String.format("%.4f", d));
                d = convert.tonToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ton.setText("ton :: " + String.format("%.4f", d));
                d = convert.tonTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.carat.setText("carat :: " + String.format("%.4f", d));
                d = convert.tonToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ounce.setText("ounce :: " + String.format("%.4f", d));
                d = convert.tonTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pound.setText("pound :: " + String.format("%.4f", d));

            } else {
                binding.mg.setText("mg :: ");
                binding.gm.setText("gm :: ");
                binding.kg.setText("kg :: ");
                binding.ton.setText("ton :: ");
                binding.carat.setText("carat :: ");
                binding.ounce.setText("ounce :: ");
                binding.pound.setText("pound :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.tonTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.tonTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.tonTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.tonToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.tonTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.tonToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.tonTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mgToton(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gmToton(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kgToton(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.tonToton(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.carratToton(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.ounceToton(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.poundToton(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void caratConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.carratTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mg.setText("mg :: " + String.format("%.4f", d));
                d = convert.carratTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gm.setText("gm :: " + String.format("%.4f", d));
                d = convert.carratTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kg.setText("kg :: " + String.format("%.4f", d));
                d = convert.carratToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ton.setText("ton :: " + String.format("%.4f", d));
                d = convert.carratTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.carat.setText("carat :: " + String.format("%.4f", d));
                d = convert.carratToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ounce.setText("ounce :: " + String.format("%.4f", d));
                d = convert.carratTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pound.setText("pound :: " + String.format("%.4f", d));

            } else {
                binding.mg.setText("mg :: ");
                binding.gm.setText("gm :: ");
                binding.kg.setText("kg :: ");
                binding.ton.setText("ton :: ");
                binding.carat.setText("carat :: ");
                binding.ounce.setText("ounce :: ");
                binding.pound.setText("pound :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.carratTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.carratTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.carratTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.carratToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.carratTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.carratToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.carratTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mgTocarrat(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gmTocarrat(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kgTocarrat(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.tonTocarrat(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.carratTocarrat(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.ounceTocarrat(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.poundTocarrat(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void ounceConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.ounceTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mg.setText("mg :: " + String.format("%.4f", d));
                d = convert.ounceTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gm.setText("gm :: " + String.format("%.4f", d));
                d = convert.ounceTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kg.setText("kg :: " + String.format("%.4f", d));
                d = convert.ounceToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ton.setText("ton :: " + String.format("%.4f", d));
                d = convert.ounceTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.carat.setText("carat :: " + String.format("%.4f", d));
                d = convert.ounceToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ounce.setText("ounce :: " + String.format("%.4f", d));
                d = convert.ounceTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pound.setText("pound :: " + String.format("%.4f", d));

            } else {
                binding.mg.setText("mg :: ");
                binding.gm.setText("gm :: ");
                binding.kg.setText("kg :: ");
                binding.ton.setText("ton :: ");
                binding.carat.setText("carat :: ");
                binding.ounce.setText("ounce :: ");
                binding.pound.setText("pound :: ");
            }
            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.ounceTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.ounceTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.ounceTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.ounceToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.ounceTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.ounceToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.ounceTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mgToounce(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gmToounce(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kgToounce(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.tonToounce(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.carratToounce(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.ounceToounce(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.poundToounce(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void poundConversion ( boolean flag){
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.poundTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mg.setText("mg :: " + String.format("%.4f", d));
                d = convert.poundTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.gm.setText("gm :: " + String.format("%.4f", d));
                d = convert.poundTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kg.setText("kg :: " + String.format("%.4f", d));
                d = convert.poundToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ton.setText("ton :: " + String.format("%.4f", d));
                d = convert.poundTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.carat.setText("carat :: " + String.format("%.4f", d));
                d = convert.poundToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.ounce.setText("ounce :: " + String.format("%.4f", d));
                d = convert.poundTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.pound.setText("pound :: " + String.format("%.4f", d));


            } else {
                binding.mg.setText("mg :: ");
                binding.gm.setText("gm :: ");
                binding.kg.setText("kg :: ");
                binding.ton.setText("ton :: ");
                binding.carat.setText("carat :: ");
                binding.ounce.setText("ounce :: ");
                binding.pound.setText("pound :: ");
            }
            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.poundTomg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.poundTogm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.poundTokg(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.poundToton(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.poundTocarrat(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.poundToounce(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.poundTopound(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mgTopound(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.gmTopound(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kgTopound(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.tonTopound(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.carratTopound(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.ounceTopound(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.poundTopound(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }
}
