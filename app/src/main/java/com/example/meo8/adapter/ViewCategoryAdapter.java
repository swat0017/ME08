package com.example.me08.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.me08.BirdFragment;
import com.example.me08.FishFragment;
import com.example.me08.Frag1;
import com.example.me08.Frag2;
import com.example.me08.Frag3;
import com.example.me08.FrogFragment;
import com.example.me08.InsectFragment;
import com.example.me08.MammalFragment;
import com.example.me08.ReptileFragment;
import com.example.me08.SpiderFragment;

public class ViewCategoryAdapter extends FragmentPagerAdapter {
    public ViewCategoryAdapter(FragmentManager fn){
        super(fn);

    }
    @Override
    public Fragment getItem(int position){
        Frag1 frag1 = new Frag1();
        position = position + 1;
        switch (position) {
            case 3:

                return frag1;

            case 2:
                Frag2 frag2=new Frag2();
                return frag2;

            case 1:
                Frag3 frag3=new Frag3();
                return frag3;



        }

        return frag1;

    }
    @Override
    public int getCount(){
        return 3;
    }
}
