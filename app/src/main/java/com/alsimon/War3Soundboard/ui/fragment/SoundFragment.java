package com.alsimon.War3Soundboard.ui.fragment;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.alsimon.War3Soundboard.R;
import com.alsimon.War3Soundboard.controller.ResourceSoundPicker;
import com.alsimon.War3Soundboard.controller.UnitPicker;
import com.alsimon.War3Soundboard.model.Race;
import com.alsimon.War3Soundboard.ui.adapter.UnitAdapter;
import com.tonicartos.superslim.LayoutManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_sound)
public class SoundFragment extends Fragment {
    public static final String RACE = "race";
    Race race;

    @Bean(ResourceSoundPicker.class)
    UnitPicker unitPicker;

    @ViewById
    RecyclerView recyclerView;

    @AfterViews
    public void init() {
        if (getArguments() != null)
            race = (Race) getArguments().getSerializable(RACE);
        else
            race = Race.HUMAN;

        recyclerView.setLayoutManager(new LayoutManager(getActivity()));
        recyclerView.setAdapter(new UnitAdapter(getActivity(), 1, unitPicker.getAllUnitsFromRace(race)));
    }

}
