package com.example.unitconverter.Converters;

import static androidx.core.content.ContextCompat.getDrawable;
import static androidx.core.content.ContextCompat.getSystemService;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.unitconverter.R;
import com.example.unitconverter.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMenuBinding.inflate(inflater, container, false);
        int lenDark_id = R.drawable.dark_length_ico;
        int lenLight_id = R.drawable.light_length_ico;
        int areaDark_id = R.drawable.dark_area_ico;
        int areaLight_id = R.drawable.light_area_ico;
        int weiDark_id = R.drawable.dark_weight_ico;
        int weiLight_id = R.drawable.light_weight_ico;
        int tempDark_id = R.drawable.dark_temperature_ico;
        int tempLight_id = R.drawable.light_temperature_ico;
        int dataDark_id = R.drawable.dark_data_ico;
        int dataLight_id = R.drawable.light_data_ico;
        int volDark_id = R.drawable.dark_volume_ico;
        int volLight_id = R.drawable.light_volume_ico;

        Drawable draw_lenDark = getResources().getDrawable(lenDark_id);
        Drawable draw_lenLight = getResources().getDrawable(lenLight_id);

        Drawable draw_areaDark = getResources().getDrawable(areaDark_id);
        Drawable draw_areaLight = getResources().getDrawable(areaLight_id);

        Drawable draw_weiDark = getResources().getDrawable(weiDark_id);
        Drawable draw_weiLight = getResources().getDrawable(weiLight_id);

        Drawable draw_tempDark = getResources().getDrawable(tempDark_id);
        Drawable draw_tempLight = getResources().getDrawable(tempLight_id);

        Drawable draw_dataDark = getResources().getDrawable(dataDark_id);
        Drawable draw_dataLight = getResources().getDrawable(dataLight_id);

        Drawable draw_volDark = getResources().getDrawable(volDark_id);
        Drawable draw_volLight = getResources().getDrawable(volLight_id);

        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_YES:

                // Dark mode is enabled

                binding.imageLength.setImageDrawable(draw_lenLight);
                binding.imageArea.setImageDrawable(draw_areaLight);
                binding.imageWeight.setImageDrawable(draw_weiLight);
                binding.imageTemperature.setImageDrawable(draw_tempLight);
                binding.imageDataStorage.setImageDrawable(draw_dataLight);
                binding.imageVolume.setImageDrawable(draw_volLight);

                break;

            case Configuration.UI_MODE_NIGHT_NO:
            case Configuration.UI_MODE_NIGHT_UNDEFINED:
                // Light mode is enabled
                binding.imageLength.setImageDrawable(draw_lenDark);
                binding.imageArea.setImageDrawable(draw_areaDark);
                binding.imageWeight.setImageDrawable(draw_weiDark);
                binding.imageTemperature.setImageDrawable(draw_tempDark);
                binding.imageDataStorage.setImageDrawable(draw_dataDark);
                binding.imageVolume.setImageDrawable(draw_volDark);
                break;
        }

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_LengthFragment);

            }
        });

        binding.area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_AreaFragment);
            }
        });

        binding.weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_WeightFragment);
            }
        });

        binding.temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_TemperatureFragment);
            }
        });

        binding.dataStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_DataStorageFragment);
            }
        });

        binding.volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_VolumeFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}