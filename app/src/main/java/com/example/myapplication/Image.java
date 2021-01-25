package com.example.myapplication;

public class Image implements Media{
    private String imageName;
    private String imageCreator;
    private long id;

    public Image(String imageName,String imageCreator,long id){
        this.imageName=imageName;
        this.imageCreator=imageCreator;
        this.id=id;
    }


}
