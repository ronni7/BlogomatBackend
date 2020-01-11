package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.Post;
import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.model.entities.dataObjects.FilterVO;

public interface PostService {
    Iterable<Post> getAllPosts();

    Post add(Post post);

    void deletePostByID(int postID);

    PostReport reportPost(PostReport report);

    Iterable<Post> getAllPostsSorted(String sort, String order);

    Iterable<Post> getAllPostsSortedByLikes();

    Iterable<Post> getAllPostsSorted(FilterVO filterVO);
}
