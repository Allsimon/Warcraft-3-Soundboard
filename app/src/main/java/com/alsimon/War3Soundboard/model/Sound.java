package com.alsimon.War3Soundboard.model;

public class Sound {

    private String name;
    private String resource;

    public Sound(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "Sound{" +
                "name='" + name + '\'' +
                ", resource='" + resource + '\'' +
                '}';
    }
}
