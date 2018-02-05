package vn.edu.fpt.se04476.mydocterproject.entities;

/**
 * Created by EDGY on 2/1/2018.
 */

public class FunctionType {
    private int tagId;
    private String type;
    private int imageResource;
    private String backgroundColor;

    public FunctionType(int tagId, String type, int imageResource, String color) {
        this.type = type;
        this.imageResource = imageResource;
        this.backgroundColor = color;
        this.tagId = tagId;
    }

    public int getTagId() {
        return tagId;
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
