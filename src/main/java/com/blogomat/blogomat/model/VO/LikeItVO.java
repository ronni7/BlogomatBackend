package com.blogomat.blogomat.model.VO;

public class LikeItVO {
    private Integer userID;
    private Integer postID;

    public LikeItVO() {
    }

    public LikeItVO(Integer userID, Integer postID) {
        this.userID = userID;
        this.postID = postID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    @Override
    public String toString() {
        return "LikeItVO{" +
                "userID=" + userID +
                ", postID=" + postID +
                '}';
    }
}
