package com.alsimon.War3Soundboard.controller;

import com.alsimon.War3Soundboard.model.Race;
import com.alsimon.War3Soundboard.model.Sound;
import com.alsimon.War3Soundboard.model.Unit;

import java.util.Collection;
import java.util.List;

public interface UnitPicker {

    public List<Unit> getAllUnits();

    public List<Unit> getAllUnitsFromRace(Race race);

}
