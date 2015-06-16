package com.alsimon.War3Soundboard.model;

import com.alsimon.War3Soundboard.R;

public enum Race {
    HUMAN(R.mipmap.ic_human_peasant, R.string.human),
    ELF(R.mipmap.ic_elf_peasant, R.string.elf),
    ORC(R.mipmap.ic_peon, R.string.orc),
    UNDEAD(R.mipmap.ic_acolyte, R.string.undead),;

    Race(int iconId, int name) {
        this.iconId = iconId;
        this.name = name;
    }

    private int iconId;
    private int name;

    public int getIconId() {
        return iconId;
    }

    public int getName() {
        return name;
    }
}
