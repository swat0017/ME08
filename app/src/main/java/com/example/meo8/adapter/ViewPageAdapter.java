package com.example.me08.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.me08.BirdFragment;
import com.example.me08.FishFragment;
import com.example.me08.Frag1;
import com.example.me08.FrogFragment;
import com.example.me08.InsectFragment;
import com.example.me08.MammalFragment;
import com.example.me08.ReptileFragment;
import com.example.me08.SpiderFragment;

public class ViewPageAdapter extends FragmentPagerAdapter {
    public ViewPageAdapter(FragmentManager fn){
        super(fn);

    }
    @Override
    public Fragment getItem(int position){
        BirdFragment frag1 = new BirdFragment();
        position = position + 1;
        switch (position) {
            case 1:

                return frag1;

            case 2:
                SpiderFragment frag2=new SpiderFragment();
                return frag2;

            case 3:
                ReptileFragment frag3=new ReptileFragment();
                return frag3;
            case 4:
                InsectFragment frag4=new InsectFragment();
                return frag4;
            case 5:
                MammalFragment frag5=new MammalFragment();
                return frag5;
            case 6:
                FrogFragment frag6=new FrogFragment();
                return frag6;
            case 7:
                FishFragment frag7=new FishFragment();
                return frag7;



        }

return frag1;

    }
    @Override
    public int getCount(){
return 7;
    }
}
