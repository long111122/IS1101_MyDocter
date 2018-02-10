package vn.edu.fpt.se04476.mydocterproject.entities;

/**
 * Created by EDGY on 2/7/2018.
 */

public class MedicalDetail {
    private int image;
    private String name;

    public MedicalDetail(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
