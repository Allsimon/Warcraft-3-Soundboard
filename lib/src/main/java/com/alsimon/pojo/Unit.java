package com.alsimon.pojo;

import java.util.ArrayList;
import java.util.List;

public class Unit {
    private Race race;
    private String name;
    private String url;
    private List<String> sounds;

    public Unit(Race race, String name, String url) {
        this.race = race;
        this.name = name;
        this.url = url;
    }

    public void addSound(String... url) {
        if (sounds == null)
            sounds = new ArrayList<>();
        for (String sound : url) {
            sounds.add(sound);
        }
    }

    public List<String> getSounds() {
        return sounds;
    }

    public Race getRace() {
        return race;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "race='" + race.getName() + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", sounds=" + sounds +
                '}';
    }
}
