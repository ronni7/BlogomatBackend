package com.blogomat.blogomat.services;

public interface LikeService {
    int getLikes(int postID);

    boolean like(int postID, int userID);
}
