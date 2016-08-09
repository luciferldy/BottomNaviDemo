package com.luc.bnd.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.luc.bnd.ui.fragment.BaseFragment;

/**
 * Created by Lucifer on 2016/8/8.
 */
public class BaseViewPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 4;
    public static final int PAGE_HOME = 0;
    public static final int PAGE_BOARD = 1;
    public static final int PAGE_GALLERY = 2;
    public static final int PAGE_MINE = 3;

    private BaseFragment mTabHome;
    private BaseFragment mTabBoard;
    private BaseFragment mTabGallery;
    private BaseFragment mTabMine;

    public BaseViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    private BaseFragment genFragment(String name) {
        BaseFragment fragment = new BaseFragment();
        Bundle b = new Bundle();
        b.putString(BaseFragment.PAGE_NAME, name);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case PAGE_HOME:
                if (mTabHome == null)
                    mTabHome = genFragment("Home");
                fragment = mTabHome;
                break;
            case PAGE_BOARD:
                if (mTabBoard == null)
                    mTabBoard = genFragment("Board");
                fragment = mTabBoard;
                break;
            case PAGE_GALLERY:
                if (mTabGallery == null)
                    mTabGallery = genFragment("Gallery");
                fragment = mTabGallery;
                break;
            case PAGE_MINE:
                if (mTabMine == null)
                    mTabMine = genFragment("Mine");
                fragment =mTabMine;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
