package com.example.lenovo.sepaltive;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lenovo on 1/13/2017.
 */

public class ImageDataParcelable implements Parcelable {
    private int likes;
    private int favorites;
    private int imageHeight;
    private int imageWidth;
    private String tags;
    private String user;
    private int comments;

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    private int downloads;
    private String previewURL;

    public ImageDataParcelable() {}

    protected ImageDataParcelable(Parcel in) {
        likes = in.readInt();
        favorites = in.readInt();
        imageHeight = in.readInt();
        imageWidth = in.readInt();
        tags = in.readString();
        user = in.readString();
        comments = in.readInt();
        downloads = in.readInt();
        previewURL = in.readString();
    }

    public static final Creator<ImageDataParcelable> CREATOR = new Creator<ImageDataParcelable>() {
        @Override
        public ImageDataParcelable createFromParcel(Parcel in) {
            return new ImageDataParcelable(in);
        }

        @Override
        public ImageDataParcelable[] newArray(int size) {
            return new ImageDataParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(likes);
        dest.writeInt(favorites);
        dest.writeInt(imageHeight);
        dest.writeInt(imageWidth);
        dest.writeString(tags);
        dest.writeString(user);
        dest.writeInt(comments);
        dest.writeInt(downloads);
        dest.writeString(previewURL);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }
}
