package com.example.ahmed.media;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MusicFragmentAdapter extends FragmentPagerAdapter {

    String[] tabs = {"Pop","Rock","Metal"};

    public MusicFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        if (i == 0) {

           return new Pop();
        } else if (i == 1) {

           return new Rock();
        } else {

          return   new Metal();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {

            return "Pop";
        }else if (position == 1) {

            return "Rock";
        }else {
            return "Metal";
        }
    }
}
