// Spencer Jones
// MDV3832-0 - 062024
// Book.java

package com.example.jonesspencer_ce09;

public class Book {
    private String title;
    private String imageUrl;

    public Book(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
