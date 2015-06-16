package com.alsimon.pojo;

/**
 * Created by a on 6/16/15.
 */
public enum Race {
    HUMAN("Human", "http://warhuman.voila.net"),
    ORC("Orc", "http://warorc.voila.net"),
    ELF("Elf", "http://warelf.voila.net"),
    HERO("Hero", "http://warcraft3.voila.net/Campaign00.htm"),
    NEUTRAL("Neutral", "http://warcraft3.voila.net/Neutral00.htm"),
    UNDEAD("Undead", "http://warundead.voila.net");
    private String name;
    private String url;

    Race(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
