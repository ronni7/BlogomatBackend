package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.Post;
import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.model.VO.FilterVO;

import java.util.Optional;

public interface PostService {
    Iterable<Post> getAllPosts();

    Post add(Post post);

    PostReport reportPost(PostReport report);

    Iterable<Post> getAllPostsSorted(String sort, String order);

    Iterable<Post> getAllPostsSortedByLikes();

    Iterable<Post> getAllPostsSorted(FilterVO filterVO);

    Iterable<Post> getAuthorPosts(String username);

    Optional<Post> getPostByID(Integer postID);
}
