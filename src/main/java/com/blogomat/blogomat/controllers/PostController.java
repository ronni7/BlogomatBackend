package com.blogomat.blogomat.controllers;

import com.blogomat.blogomat.model.entities.Post;
import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.model.VO.FilterVO;
import com.blogomat.blogomat.model.VO.LikeItVO;
import com.blogomat.blogomat.services.LikeServiceImpl;
import com.blogomat.blogomat.services.PostServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/post")
public class PostController {
    private final PostServiceImpl postService;
    private final LikeServiceImpl likeService;

    public PostController(PostServiceImpl postService, LikeServiceImpl likeService) {
        this.postService = postService;
        this.likeService = likeService;
    }

    @GetMapping(path = "/postsTest")
    public @ResponseBody
    Iterable<Post> getPostsTest() {
        return postService.getAllPosts();
    }

    @GetMapping(path = "/posts")
    public @ResponseBody
    Iterable<Post> getPosts(@RequestParam String sort, @RequestParam String order) {
        System.out.println("sort  = " + sort);
        System.out.println("order = " + order);
        return postService.getAllPostsSorted(sort, order);
    }

    @PostMapping(path = "/postsFiltered")
    public @ResponseBody
    Iterable<Post> getPostsFiltered(@RequestBody FilterVO filterVO) {
        System.out.println("filterVO = " + filterVO);
        return postService.getAllPostsSorted(filterVO);
    }
    @PostMapping(path = "/postsByAuthorName")
    public @ResponseBody
    Iterable<Post> getAuthorPosts(@RequestBody String username) {
        return postService.getAuthorPosts(username);
    }
    @GetMapping(path = "/postsSortedByLikes")
    public @ResponseBody
    Iterable<Post> getPostsSortedByLikes() {

        return postService.getAllPostsSortedByLikes();
    }

    //  @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/add")
    public @ResponseBody
    Post addPost(@RequestBody Post post) {
        return postService.add(post);
    }

    //  @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/like")
    public @ResponseBody
    void like(@RequestBody LikeItVO likeVO) {
         likeService.like(likeVO.getPostID(), likeVO.getUserID());
    }

    @PostMapping(path = "/getLikes")
    public @ResponseBody
    int getLikes(@RequestBody Integer postID) {
        return likeService.getLikes(postID);
    }

    //@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/reportPost")
    public @ResponseBody
    PostReport report(@RequestBody PostReport report) {
        return postService.reportPost(report);
    }


    @GetMapping(path = "/getPost/{postID}")
    public @ResponseBody
    Optional<Post> getPostByID(@PathVariable Integer postID)
    {
        return postService.getPostByID(postID);
    }

}
