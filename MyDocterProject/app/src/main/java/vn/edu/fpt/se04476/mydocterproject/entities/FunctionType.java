package vn.edu.fpt.se04476.mydocterproject.entities;

/**
 * Created by EDGY on 2/1/2018.
 */

public class FunctionType {
    private String type;
    private int imageResource;
    private String backgroundColor;

    public FunctionType(String type, int imageResource, String color) {
        this.type = type;
        this.imageResource = imageResource;
        this.backgroundColor = color;
    }

    public String getType() {
        return type;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }
}
