package com.pari.bikeshop.products;

public class Color {
    private String colorCode;
    private String imageUrl;

    public Color(String colorCode, String imageUrl) {
        this.colorCode = colorCode;
        this.imageUrl = imageUrl;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
