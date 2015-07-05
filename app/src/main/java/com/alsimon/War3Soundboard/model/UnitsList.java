package com.alsimon.War3Soundboard.model;

import java.util.List;

public class UnitsList {

    private List<Unit> units;

    public UnitsList(List<Unit> units) {
        this.units = units;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
