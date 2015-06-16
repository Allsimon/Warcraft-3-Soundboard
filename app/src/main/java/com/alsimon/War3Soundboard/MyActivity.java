package com.alsimon.War3Soundboard;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;


@EActivity
public class MyActivity extends AbstractActivity {


    @AfterInject
    public void addCallbacks() {
    }


    @Override
    public void prepareListData() {
        mNavDrawerItems = new ArrayList<>();
//        mNavDrawerItems.add(new NavDrawerItem(getResources().getString(R.string.debridLinks), R.drawable.ic_download) {
//            @Override
//            public void onClick() {
//                changeFragment(new LinkFragment_());
//            }
//        });
        refreshHeader();
        refreshNavDrawer();
    }

    private void refreshHeader() {
    }

    @Override
    public void initFragment() {
    }
}
