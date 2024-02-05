package com.example.todo.Adapters;

import android.graphics.drawable.Icon;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.todo.Fragment.Fragment_task;

import java.util.ArrayList;
import java.util.List;
/*
public class VPAdapter extends FragmentStateAdapter {

    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> fragmentTitle;
    private final ArrayList<Icon> fragmentIcon = new ArrayList<>();

    int mNumOfTabs;

    public VPAdapter(@NonNull FragmentManager fm, int NumOfTabs, ArrayList<String> tabName) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.fragmentTitle = tabName;
        //Log.e("Frag Title1", "tab: " + tabName.size());
    }

    @NonNull
    @Override
    public Fragment getItem(int position){
        Log.e("Frag Title1", "tab000: " + fragmentTitle.get(position));
        return Fragment_task.newInstance(position, fragmentTitle.get(position));
//        return Fragment_task.newInstance(position);
    }

    @Override
    public int getCount(){
        return mNumOfTabs;
    }

    public void addFragment(Fragment fragment, String title){
        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);

    }

    public void addFragment(Fragment fragment, Icon icon){
        fragmentArrayList.add(fragment);
        fragmentIcon.add(icon);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return fragmentTitle.get(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
 */


public class VPAdapter extends FragmentStateAdapter {

    private final ArrayList<String> date = new ArrayList<>();
    private final ArrayList<Integer> status = new ArrayList<>();
    private final ArrayList<Integer> favTask = new ArrayList<>();
    private final ArrayList<String> fragmentTitle;
    private final ArrayList<Icon> fragmentIcon = new ArrayList<>();

    public VPAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<String> tabName) {
        super(fragmentManager, lifecycle);
        this.fragmentTitle = tabName;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return Fragment_task.newInstance(position, fragmentTitle.get(position));
    }

    @Override
    public int getItemCount() {
        return fragmentTitle.size();
    }

}

