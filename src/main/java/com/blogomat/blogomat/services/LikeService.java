package com.blogomat.blogomat.services;

public interface LikeService {
    int getLikes(int postID);

    void like(int postID, int userID);
}
