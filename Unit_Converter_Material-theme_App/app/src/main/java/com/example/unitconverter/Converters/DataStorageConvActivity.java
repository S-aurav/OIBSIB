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
import com.example.unitconverter.databinding.ActivityDataStorageConverterBinding;

import java.util.ArrayList;
import java.util.List;


public class DataStorageConvActivity extends AppCompatActivity {

    private List<String> lengthList;
    private AppBarConfiguration appBarConfiguration;
    double d = 0.00;
    private TextWatcher textWatcher;
    public ActivityDataStorageConverterBinding binding;
    Convert convert = new Convert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDataStorageConverterBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        //Initialising the length list.
        lengthList = new ArrayList<>();
        lengthList.add("bytes");
        lengthList.add("kilobits");
        lengthList.add("kiloBytes");
        lengthList.add("Megabits");
        lengthList.add("MegaBytes");
        lengthList.add("Gigabits");
        lengthList.add("GigaBytes");
        lengthList.add("TeraBytes");


        binding.fromSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.purplegrad_array_upper, lengthList));
        binding.toSpin.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.purplegrad_array_lower, lengthList));
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
                            bytesConversion(true);
                            break;
                        case 1:
                            kbConversion(true);
                            break;
                        case 2:
                            kBConversion(true);
                            break;
                        case 3:
                            MbConversion(true);
                            break;
                        case 4:
                            MBConversion(true);
                            break;
                        case 5:
                            GbConversion(true);
                            break;
                        case 6:
                            GBConversion(true);
                            break;
                        case 7:
                            TBConversion(true);
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
                            bytesConversion(false);
                            break;
                        case 1:
                            kbConversion(false);
                            break;
                        case 2:
                            kBConversion(false);
                            break;
                        case 3:
                            MbConversion(false);
                            break;
                        case 4:
                            MBConversion(false);
                            break;
                        case 5:
                            GbConversion(false);
                            break;
                        case 6:
                            GBConversion(false);
                            break;
                        case 7:
                            TBConversion(false);
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
                        bytesConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        kbConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        kBConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        MbConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        MBConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        GbConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        GBConversion(true);
                        addingWatcher();
                        break;
                    case 7:
                        removingWatcher();
                        TBConversion(true);
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
                        bytesConversion(true);
                        addingWatcher();
                        break;
                    case 1:
                        removingWatcher();
                        kbConversion(true);
                        addingWatcher();
                        break;
                    case 2:
                        removingWatcher();
                        kBConversion(true);
                        addingWatcher();
                        break;
                    case 3:
                        removingWatcher();
                        MbConversion(true);
                        addingWatcher();
                        break;
                    case 4:
                        removingWatcher();
                        MBConversion(true);
                        addingWatcher();
                        break;
                    case 5:
                        removingWatcher();
                        GbConversion(true);
                        addingWatcher();
                        break;
                    case 6:
                        removingWatcher();
                        GBConversion(true);
                        addingWatcher();
                        break;
                    case 7:
                        removingWatcher();
                        TBConversion(true);
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

    private void bytesConversion(boolean flag) {

        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.byteTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.byteTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.byteTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.byteToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.byteToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.byteToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.byteToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.byteToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }


            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.byteToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteTobyte(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbTobyte(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBTobyte(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbTobyte(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBTobyte(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbTobyte(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBTobyte(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBTobytes(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }


    private void kbConversion(boolean flag) {
        if (flag) {


            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.kbTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.kbTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.kbTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.kbToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.kbToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.kbToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.kbToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.kbToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kbToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBTokb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }
    }

    private void kBConversion(boolean flag) {
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.kBTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.kBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.kBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.kBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.kBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.kBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.kBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.kBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.kBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbTokB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBTokB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbTokB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBTokB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbTokB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBTokB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBTokB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void MbConversion(boolean flag) {
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.MbTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.MbTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.MbTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.MbToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.MbToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.MbToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.MbToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.MbToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MbToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBToMb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void MBConversion(boolean flag) {
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.MBTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.MBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.MBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.MBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.MBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.MBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.MBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.MBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.MBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBToMB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void GbConversion(boolean flag) {
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.GbTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.GbTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.GbTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.GbToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.GbToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.GbToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.GbToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.GbToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }
            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GbToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBToGb(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void GBConversion(boolean flag) {
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.GBTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.GBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.GBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.GBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.GBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.GBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.GBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.GBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }
            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBTobyte(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.GBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBToGB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }

    private void TBConversion(boolean flag) {
        if (flag) {

            if (!binding.fromText.getText().toString().trim().equals("")) {
                d = convert.TBTobytes(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.bytes.setText("bytes :: " + String.format("%.4f", d));
                d = convert.TBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kb.setText("kilobits :: " + String.format("%.4f", d));
                d = convert.TBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.kB.setText("kiloBytes :: " + String.format("%.4f", d));
                d = convert.TBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Mb.setText("Megabits :: " + String.format("%.4f", d));
                d = convert.TBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.MB.setText("MegaBytes :: " + String.format("%.4f", d));
                d = convert.TBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.Gb.setText("Gigabits :: " + String.format("%.4f", d));
                d = convert.TBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.GB.setText("GigaBytes :: " + String.format("%.4f", d));
                d = convert.TBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                binding.TB.setText("TeraBytes :: " + String.format("%.4f", d));

            } else {
                binding.bytes.setText("bytes :: ");
                binding.kb.setText("kilobits :: ");
                binding.kB.setText("kiloBytes :: ");
                binding.Mb.setText("Megabits :: ");
                binding.MB.setText("MegaBytes :: ");
                binding.Gb.setText("Gigabits :: ");
                binding.GB.setText("GigaBytes :: ");
                binding.TB.setText("TeraBytes :: ");
            }

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBTobytes(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBTokb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBTokB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBToMb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBToMB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBToGb(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBToGB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.fromText.getText().toString().trim().equals("")) {
                        d = convert.TBToTB(Double.parseDouble(binding.fromText.getText().toString().trim()));
                        binding.toText.setText(String.format("%.4f", d));
                    }
                    break;
            }


        } else {

            switch (binding.toSpin.getSelectedItemPosition()) {
                case 0:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.byteToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 1:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kbToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 2:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.kBToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 3:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MbToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 4:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.MBToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 5:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GbToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 6:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.GBToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;

                case 7:
                    if (!binding.toText.getText().toString().trim().equals("")) {
                        d = convert.TBToTB(Double.parseDouble(binding.toText.getText().toString().trim()));
                        binding.fromText.setText(String.format("%.4f", d));
                    }
                    break;
            }
        }

    }
}