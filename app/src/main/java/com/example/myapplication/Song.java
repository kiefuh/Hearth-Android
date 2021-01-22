package com.example.myapplication;

import android.net.Uri;

public class Song {
    long songID;
    String songName;
    String artist;

    public Song(long songID, String name, String artist){
        this.songID =songID;
        this.songName=name;
        this.artist=artist;
    }

    public long getSongUri() {
        return songID;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songID=" + songID +
                ", songName='" + songName + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
