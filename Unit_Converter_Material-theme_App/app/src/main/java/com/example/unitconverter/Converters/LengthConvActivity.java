package com.example.unitconverter.Converters;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.unitconverter.Convert;
import com.example.unitconverter.R;
import com.example.unitconverter.databinding.ActivityLengthConverterBinding;


import java.util.ArrayList;
import java.util.List;

public class LengthConvActivity extends AppCompatActivity {

    private List<String> lengthList;
    private AppBarConfiguration appBarConfiguration;
    double d = 0.00;
    private TextWatcher textWatcher;
    public ActivityLengthConverterBinding binding;
    Convert convert = new Convert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLengthConverterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        //Initialising the length list.
        lengthList = new ArrayList<>();
        lengthList.add("mm");
        lengthList.add("cm");
        lengthList.add("m");
        lengthList.add("km");
        lengthList.add("inch");
        lengthList.add("foot");
        lengthList.add("yard");
        lengthList.add("mile");


        binding.fromSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.redgrad_array_upper, lengthList));
        binding.toSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.redgrad_array_lower, lengthList));
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
                            mmConversion(true);
                            break;
                        case 1:
                            cmConversion(true);
                            break;
                        case 2:
                            mConversion(true);
                            break;
                        case 3:
                            kmConversion(true);
                            break;
                        case 4:
                            inchConversion(true);
                            break;
                        case 5:
                            footConversion(true);
                            break;
                        case 6:
                            yardConversion(true);
                            break;
                        case 7:
                            mileConversion(true);
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
                            mmConversion(false);
                            break;
                        case 1:
                            cmConversion(false);
                            break;
                        case 2:
                            mConversion(false);
                            break;
                        case 3:
                            kmConversion(false);
                            break;
                        case 4:
                            inchConversion(false);
                            break;
                        case 5:
                            footConversion(false);
                            break;
                        case 6:
                            yardConversion(false);
                            break;
                        case 7:
                            mileConversion(false);
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
                        mmConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        cmConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        mConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        kmConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        inchConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        footConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        yardConversion(true);
                        addingWatcher();
                        break;
                    case 7:
                        removingWatcher();
                        mileConversion(true);
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
                        mmConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        cmConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        mConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        kmConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        inchConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        footConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        yardConversion(true);
                        addingWatcher();
                        break;
                    case 7:
                        removingWatcher();
                        mileConversion(true);
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

    private void mmConversion(boolean flag) {

        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.mmtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mm.setText("mm :: " + String.format("%.4f", d));
                d = convert.mmtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cm.setText("cm :: " + String.format("%.4f", d));
                d = convert.mmtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.m.setText("m :: " + String.format("%.4f", d));
                d = convert.mmtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.km.setText("km :: " + String.format("%.4f", d));
                d = convert.mmtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.inch.setText("inch :: " + String.format("%.4f", d));
                d = convert.mmtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.foot.setText("foot :: " + String.format("%.4f", d));
                d = convert.mmtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.yard.setText("yard :: " + String.format("%.4f", d));
                d = convert.mmtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mile.setText("mile :: " + String.format("%.4f", d));

            } else {
                binding.mm.setText("mm :: ");
                binding.cm.setText("cm :: ");
                binding.m.setText("m :: ");
                binding.km.setText("km :: ");
                binding.inch.setText("inch :: ");
                binding.foot.setText("foot :: ");
                binding.yard.setText("yard :: ");
                binding.mile.setText("mile :: ");
            }


            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.mmtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mmtomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cmtomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mtomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kmtomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.inchtomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.foottomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.yardtomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mitomm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }



    private void cmConversion ( boolean flag){
        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.cmtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mm.setText("mm :: " + String.format("%.4f", d));
                d = convert.cmtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.cm.setText("cm :: " + String.format("%.4f", d));
                d = convert.cmtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.m.setText("m :: " + String.format("%.4f", d));
                d = convert.cmtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.km.setText("km :: " + String.format("%.4f", d));
                d = convert.cmtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.inch.setText("inch :: " + String.format("%.4f", d));
                d = convert.cmtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.foot.setText("foot :: " + String.format("%.4f", d));
                d = convert.cmtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.yard.setText("yard :: " + String.format("%.4f", d));
                d = convert.cmtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.mile.setText("mile :: " + String.format("%.4f", d));

            } else {
                binding.mm.setText("mm :: ");
                binding.cm.setText("cm :: ");
                binding.m.setText("m :: ");
                binding.km.setText("km :: ");
                binding.inch.setText("inch :: ");
                binding.foot.setText("foot :: ");
                binding.yard.setText("yard :: ");
                binding.mile.setText("mile :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.cmtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mmtocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.cmtocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mtocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kmtocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.inchtocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.foottocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.yardtocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.mitocm(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }

        private void mConversion ( boolean flag){
            if (flag) {

                if (!binding.fromText.getText().toString().trim().equals("")) {
                    d = convert.mtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mm.setText("mm :: " + String.format("%.4f", d));
                    d = convert.mtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.cm.setText("cm :: " + String.format("%.4f", d));
                    d = convert.mtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.m.setText("m :: " + String.format("%.4f", d));
                    d = convert.mtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.km.setText("km :: " + String.format("%.4f", d));
                    d = convert.mtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.inch.setText("inch :: " + String.format("%.4f", d));
                    d = convert.mtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.foot.setText("foot :: " + String.format("%.4f", d));
                    d = convert.mtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.yard.setText("yard :: " + String.format("%.4f", d));
                    d = convert.mtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mile.setText("mile :: " + String.format("%.4f", d));

                } else {
                    binding.mm.setText("mm :: ");
                    binding.cm.setText("cm :: ");
                    binding.m.setText("m :: ");
                    binding.km.setText("km :: ");
                    binding.inch.setText("inch :: ");
                    binding.foot.setText("foot :: ");
                    binding.yard.setText("yard :: ");
                    binding.mile.setText("mile :: ");
                }

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;
                }


            } else {

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mmtom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.cmtom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mtom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.kmtom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.inchtom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.foottom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.yardtom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mitom(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;
                }
            }

        }

        private void kmConversion ( boolean flag){
            if (flag) {

                if (!binding.fromText.getText().toString().trim().equals("")) {
                    d = convert.kmtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mm.setText("mm :: " + String.format("%.4f", d));
                    d = convert.kmtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.cm.setText("cm :: " + String.format("%.4f", d));
                    d = convert.kmtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.m.setText("m :: " + String.format("%.4f", d));
                    d = convert.kmtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.km.setText("km :: " + String.format("%.4f", d));
                    d = convert.kmtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.inch.setText("inch :: " + String.format("%.4f", d));
                    d = convert.kmtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.foot.setText("foot :: " + String.format("%.4f", d));
                    d = convert.kmtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.yard.setText("yard :: " + String.format("%.4f", d));
                    d = convert.kmtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mile.setText("mile :: " + String.format("%.4f", d));

                } else {
                    binding.mm.setText("mm :: ");
                    binding.cm.setText("cm :: ");
                    binding.m.setText("m :: ");
                    binding.km.setText("km :: ");
                    binding.inch.setText("inch :: ");
                    binding.foot.setText("foot :: ");
                    binding.yard.setText("yard :: ");
                    binding.mile.setText("mile :: ");
                }

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.kmtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;
                }


            } else {

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mmtokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.cmtokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mtokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.kmtokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.inchtokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.foottokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.yardtokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mitokm(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;
                }
            }

        }

        private void inchConversion ( boolean flag){
            if (flag) {

                if (!binding.fromText.getText().toString().trim().equals("")) {
                    d = convert.inchtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mm.setText("mm :: " + String.format("%.4f", d));
                    d = convert.inchtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.cm.setText("cm :: " + String.format("%.4f", d));
                    d = convert.inchtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.m.setText("m :: " + String.format("%.4f", d));
                    d = convert.inchtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.km.setText("km :: " + String.format("%.4f", d));
                    d = convert.inchtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.inch.setText("inch :: " + String.format("%.4f", d));
                    d = convert.inchtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.foot.setText("foot :: " + String.format("%.4f", d));
                    d = convert.inchtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.yard.setText("yard :: " + String.format("%.4f", d));
                    d = convert.inchtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mile.setText("mile :: " + String.format("%.4f", d));

                } else {
                    binding.mm.setText("mm :: ");
                    binding.cm.setText("cm :: ");
                    binding.m.setText("m :: ");
                    binding.km.setText("km :: ");
                    binding.inch.setText("inch :: ");
                    binding.foot.setText("foot :: ");
                    binding.yard.setText("yard :: ");
                    binding.mile.setText("mile :: ");
                }

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.inchtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;
                }


            } else {

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mmtoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.cmtoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mtoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.kmtoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.inchtoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.foottoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.yardtoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mitoinch(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;
                }
            }

        }

        private void footConversion ( boolean flag){
            if (flag) {

                if (!binding.fromText.getText().toString().trim().equals("")) {
                    d = convert.foottomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mm.setText("mm :: " + String.format("%.4f", d));
                    d = convert.foottocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.cm.setText("cm :: " + String.format("%.4f", d));
                    d = convert.foottom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.m.setText("m :: " + String.format("%.4f", d));
                    d = convert.foottokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.km.setText("km :: " + String.format("%.4f", d));
                    d = convert.foottoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.inch.setText("inch :: " + String.format("%.4f", d));
                    d = convert.foottofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.foot.setText("foot :: " + String.format("%.4f", d));
                    d = convert.foottoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.yard.setText("yard :: " + String.format("%.4f", d));
                    d = convert.foottomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mile.setText("mile :: " + String.format("%.4f", d));

                } else {
                    binding.mm.setText("mm :: ");
                    binding.cm.setText("cm :: ");
                    binding.m.setText("m :: ");
                    binding.km.setText("km :: ");
                    binding.inch.setText("inch :: ");
                    binding.foot.setText("foot :: ");
                    binding.yard.setText("yard :: ");
                    binding.mile.setText("mile :: ");
                }
                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.foottomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;
                }


            } else {

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mmtofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.cmtofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mtofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.kmtofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.inchtofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.foottofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.yardtofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mitofoot(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;
                }
            }

        }

        private void yardConversion ( boolean flag){
            if (flag) {

                if (!binding.fromText.getText().toString().trim().equals("")) {
                    d = convert.yardtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mm.setText("mm :: " + String.format("%.4f", d));
                    d = convert.yardtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.cm.setText("cm :: " + String.format("%.4f", d));
                    d = convert.yardtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.m.setText("m :: " + String.format("%.4f", d));
                    d = convert.yardtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.km.setText("km :: " + String.format("%.4f", d));
                    d = convert.yardtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.inch.setText("inch :: " + String.format("%.4f", d));
                    d = convert.yardtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.foot.setText("foot :: " + String.format("%.4f", d));
                    d = convert.yardtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.yard.setText("yard :: " + String.format("%.4f", d));
                    d = convert.yardtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mile.setText("mile :: " + String.format("%.4f", d));

                } else {
                    binding.mm.setText("mm :: ");
                    binding.cm.setText("cm :: ");
                    binding.m.setText("m :: ");
                    binding.km.setText("km :: ");
                    binding.inch.setText("inch :: ");
                    binding.foot.setText("foot :: ");
                    binding.yard.setText("yard :: ");
                    binding.mile.setText("mile :: ");
                }
                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.yardtomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;
                }


            } else {

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mmtoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.cmtoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mtoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.kmtoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.inchtoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.foottoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.yardtoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mitoyard(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;
                }
            }

        }

        private void mileConversion ( boolean flag){
            if (flag) {

                if (!binding.fromText.getText().toString().trim().equals("")) {
                    d = convert.mitomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mm.setText("mm :: " + String.format("%.4f", d));
                    d = convert.mitocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.cm.setText("cm :: " + String.format("%.4f", d));
                    d = convert.mitom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.m.setText("m :: " + String.format("%.4f", d));
                    d = convert.mitokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.km.setText("km :: " + String.format("%.4f", d));
                    d = convert.mitoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.inch.setText("inch :: " + String.format("%.4f", d));
                    d = convert.mitofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.foot.setText("foot :: " + String.format("%.4f", d));
                    d = convert.mitoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.yard.setText("yard :: " + String.format("%.4f", d));
                    d = convert.mitomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                    binding.mile.setText("mile :: " + String.format("%.4f", d));

                } else {
                    binding.mm.setText("mm :: ");
                    binding.cm.setText("cm :: ");
                    binding.m.setText("m :: ");
                    binding.km.setText("km :: ");
                    binding.inch.setText("inch :: ");
                    binding.foot.setText("foot :: ");
                    binding.yard.setText("yard :: ");
                    binding.mile.setText("mile :: ");
                }

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitomm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitocm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitom(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitokm(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitoinch(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitofoot(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitoyard(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.fromText.getText().toString().trim().equals("")) {
                            d = convert.mitomi(Double.parseDouble(binding.fromText.getText().toString().trim()));
                            binding.toText.setText(String.format("%.4f", d));
                        }
                        break;
                }


            } else {

                switch (binding.toSpin.getSelectedItemPosition()) {
                    case 0:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mmtomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 1:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.cmtomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 2:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mtomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 3:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.kmtomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 4:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.inchtomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 5:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.foottomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 6:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.yardtomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;

                    case 7:
                        if (!binding.toText.getText().toString().trim().equals("")) {
                            d = convert.mitomi(Double.parseDouble(binding.toText.getText().toString().trim()));
                            binding.fromText.setText(String.format("%.4f", d));
                        }
                        break;
                }
            }

        }

}
