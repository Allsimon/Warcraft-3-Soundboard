package com.alsimon.War3Soundboard.model;

import java.util.ArrayList;
import java.util.Collection;

public class Unit {

    private Race race;
    private String name;
    private Collection<Sound> sounds;

    @Override
    public String toString() {
        return "Unit{" +
                "race=" + race +
                ", name='" + name + '\'' +
                ", sounds=" + sounds +
                '}';
    }

    public Unit(Race race, String name, String... sounds) {
        this.race = race;
        this.name = name;
        for (String sound : sounds) {
            addSound(new Sound(sound));
        }

    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSound(Sound sound) {
        if (sounds == null)
            sounds = new ArrayList<>();
        sounds.add(sound);
    }

    public Collection<Sound> getSounds() {
        return sounds;
    }

    public void setSounds(Collection<Sound> sounds) {
        this.sounds = sounds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unit)) return false;


        Unit unit = (Unit) o;

        return getRace() == unit.getRace() && !(getName() != null ? !getName().equals(unit.getName()) : unit.getName() != null);

    }

    @Override
    public int hashCode() {
        int result = getRace() != null ? getRace().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }
}
