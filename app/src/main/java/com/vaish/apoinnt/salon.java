package com.vaish.apoinnt;



public class salon {
    private String name;
    private String description;
    private String price;
    private float rating;
    private String location;
    private int imageResource;

    public salon(String name, String description, String price, float rating, String location, int imageResource) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.location = location;
        this.imageResource = imageResource;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
    public float getRating() { return rating; }
    public String getLocation() { return location; }
    public int getImageResource() { return imageResource; }
}
