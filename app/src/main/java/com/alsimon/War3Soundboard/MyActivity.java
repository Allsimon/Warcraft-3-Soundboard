package com.alsimon.War3Soundboard;

import com.alsimon.War3Soundboard.model.Race;
import com.alsimon.War3Soundboard.ui.adapter.NavDrawerItem;
import com.alsimon.War3Soundboard.ui.fragment.SoundFragment;
import com.alsimon.War3Soundboard.ui.fragment.SoundFragment_;

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
        for (Race race : Race.values()) {
            mNavDrawerItems.add(new NavDrawerItem(getResources().getString(race.getName()), race.getIconId()) {
                @Override
                public void onClick() {
                    changeFragment(new SoundFragment_());
                }
            });
        }

        refreshHeader();
        refreshNavDrawer();
    }

    private void refreshHeader() {
    }

    @Override
    public void initFragment() {
    }
}
