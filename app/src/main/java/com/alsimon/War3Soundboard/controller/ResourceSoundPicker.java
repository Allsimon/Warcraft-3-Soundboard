package com.alsimon.War3Soundboard.controller;


import android.content.Context;

import com.alsimon.War3Soundboard.R;
import com.alsimon.War3Soundboard.model.Race;
import com.alsimon.War3Soundboard.model.Unit;
import com.alsimon.War3Soundboard.model.UnitsList;
import com.alsimon.War3Soundboard.utils.Logg;
import com.google.gson.Gson;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@EBean
public class ResourceSoundPicker implements UnitPicker {

    @RootContext
    Context context;

    List<Unit> units;

    @Override
    public List<Unit> getAllUnits() {
        if (units == null) {
            units = new ArrayList<>();
            Gson gson = new Gson();
            InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(R.raw.sound));
            units = gson.fromJson(inputStreamReader, UnitsList.class).getUnits();
        }
        return units;
    }

    @Override
    public List<Unit> getAllUnitsFromRace(Race race) {
        List<Unit> unitsFromRace = new ArrayList<>();
        for (Unit unit : getAllUnits())
            if (unit.getRace() == race)
                unitsFromRace.add(unit);
        return unitsFromRace;
    }
}
