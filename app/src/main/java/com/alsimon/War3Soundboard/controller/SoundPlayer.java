package com.alsimon.War3Soundboard.controller;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public enum SoundPlayer {
    INSTANCE;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void play(String resource) {
        try {
            AssetFileDescriptor afd = context.getResources().getAssets().openFd(resource);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
