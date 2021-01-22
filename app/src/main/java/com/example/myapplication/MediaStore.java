package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;

public class MediaStore {
    private HashMap<String,ArrayList<Media>> mediaMap;

    public MediaStore(){
        mediaMap= new HashMap<>(10);
        mediaMap.put("songs",new ArrayList<Media>());
        mediaMap.put("videos",new ArrayList<Media>());
        mediaMap.put("images",new ArrayList<Media>());
    }

    public void addSong(Song song){
        mediaMap.get("songs").add(song);
    }

    public void addVideo(Media media){
        mediaMap.get("videos").add(media);
    }

    public void addImage(Media media){
        mediaMap.get("images").add(media);
    }
}
