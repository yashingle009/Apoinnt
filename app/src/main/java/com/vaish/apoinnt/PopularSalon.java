package com.vaish.apoinnt;

import android.os.Parcel;
import android.os.Parcelable;

public class PopularSalon implements Parcelable {
    private String name;
    private String imageUrl;
    private boolean isOpen;
    private String timing;
    private float distance;

    public PopularSalon(String name, String imageUrl, boolean isOpen, String timing, float distance) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.isOpen = isOpen;
        this.timing = timing;
        this.distance = distance;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getTiming() {
        return timing;
    }

    public float getDistance() {
        return distance;
    }

    // Parcelable implementation (required for passing the object between fragments)
    protected PopularSalon(Parcel in) {
        name = in.readString();
        imageUrl = in.readString();
        isOpen = in.readByte() != 0;
        timing = in.readString();
        distance = in.readFloat();
    }

    public static final Creator<PopularSalon> CREATOR = new Creator<PopularSalon>() {
        @Override
        public PopularSalon createFromParcel(Parcel in) {
            return new PopularSalon(in);
        }

        @Override
        public PopularSalon[] newArray(int size) {
            return new PopularSalon[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(imageUrl);
        dest.writeByte((byte) (isOpen ? 1 : 0));
        dest.writeString(timing);
        dest.writeFloat(distance);
    }
}