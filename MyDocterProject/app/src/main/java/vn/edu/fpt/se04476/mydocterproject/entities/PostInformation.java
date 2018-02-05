package vn.edu.fpt.se04476.mydocterproject.entities;

import android.media.Image;

import java.util.List;

/**
 * Created by EDGY on 2/4/2018.
 */

public class PostInformation {
    private int postId;
    private int avaImage;
    private int postImage;
    private String user;
    private String startTime;
    private String content;
    private String title;
    private List<String> Image;
    private boolean isApplied;

    public PostInformation(int postId, int avaImage, int postImage, String user, String startTime, String content, String title, List<String> image, boolean isApplied) {
        this.avaImage = avaImage;
        this.postImage = postImage;
        this.postId = postId;
        this.user = user;
        this.startTime = startTime;
        this.content = content;
        this.title = title;
        Image = image;
        this.isApplied = isApplied;
    }

    public String getTitle() {
        return title;
    }

    public int getAvaImage() {
        return avaImage;
    }

    public int getPostImage() {
        return postImage;
    }

    public int getPostId() {
        return postId;
    }

    public String getUser() {
        return user;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getContent() {
        return content;
    }

    public List<String> getImage() {
        return Image;
    }

    public boolean isApplied() {
        return isApplied;
    }
}
