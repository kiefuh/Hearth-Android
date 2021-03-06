package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.net.URI;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    TextView whoIsView;
    ArrayList<Song> songArrayList;
    ArrayAdapter<Song> adapter;
    ListView songList;
    Button johnButton;
    Button jeffButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);            }
        }else{
            init();
        }
    }


    public void getMusic() {
        ContentResolver contentResolver = getContentResolver();
        Uri songURI = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = null;
        songCursor = contentResolver.query(songURI, null, null, null, null);


        if (songCursor != null && songCursor.moveToFirst()) {
            int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int songLength = songCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            int songID = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);

            do {
                String currentTitle = songCursor.getString(songTitle);
                String currentArtist = songCursor.getString(songArtist);
                String currentLength = songCursor.getString(songLength);
                long currentID = songCursor.getLong(songID);
                Song song = new Song(currentID, currentTitle, currentArtist);
                System.out.println(currentTitle);
                songArrayList.add(song);

            } while (songCursor.moveToNext());


        }

    }

    public void getImages(){
        ContentResolver contentResolver = getContentResolver();
        Uri photoURI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor imageCursor = null;
        imageCursor = contentResolver.query(photoURI, null, null, null, null);


        if (imageCursor != null && imageCursor.moveToFirst()) {
            int imageTitle = imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
            int imageArtist = imageCursor.getColumnIndex(MediaStore.Images.Media.AUTHOR);;
            int imageID = imageCursor.getColumnIndex(MediaStore.Images.Media._ID);

            do {
                String currentTitle = imageCursor.getString(imageTitle);
                String currentArtist = imageCursor.getString(imageArtist);
                long currentID = imageCursor.getLong(imageID);
                Image image = new Image(currentTitle, currentArtist, currentID);
                System.out.println(currentTitle);
            } while (imageCursor.moveToNext());


        }
    }

    public void getVideo(){
        ContentResolver contentResolver = getContentResolver();
        Uri photoURI = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor videoCursor = null;
        videoCursor = contentResolver.query(photoURI, null, null, null, null);


        if (videoCursor != null && videoCursor.moveToFirst()) {
            int songTitle = videoCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist = videoCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int songLength = videoCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            int songID = videoCursor.getColumnIndex(MediaStore.Audio.Media._ID);

            do {
                String currentTitle = videoCursor.getString(songTitle);
                String currentArtist = videoCursor.getString(songArtist);
                String currentLength = videoCursor.getString(songLength);
                long currentID = videoCursor.getLong(songID);
                Song song = new Song(currentID, currentTitle, currentArtist);
                System.out.println(currentTitle);
                songArrayList.add(song);

            } while (videoCursor.moveToNext());


        }
    }

    public void init() {
        songList = (ListView) findViewById(R.id.songList);
        songArrayList = new ArrayList<>();
        TextView tv = (TextView) findViewById(R.id.testView);
        tv.setText("It worked");
        getMusic();
        adapter = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, songArrayList);
        songList.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission granted!", Toast.LENGTH_SHORT).show();
                        init();
                    } else {
                        Toast.makeText(this, "No permission granted", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    return;
                }
            }
        }
    }


}