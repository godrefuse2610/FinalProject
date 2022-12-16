package com.example.myapplication.model;

public class BannerMovies {
    String imageUrl;
    int imageBanner;

    public BannerMovies(int imageBanner) {
        this.imageBanner = imageBanner;
    }

    public BannerMovies(String imageUrl, int imageBanner) {
        this.imageUrl = imageUrl;
        this.imageBanner = imageBanner;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageBanner() { return imageBanner; }

    public void setImageBanner(int imageBanner) { this.imageBanner = imageBanner; }
}
