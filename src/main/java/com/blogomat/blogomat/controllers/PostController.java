package com.blogomat.blogomat.controllers;

import com.blogomat.blogomat.model.entities.Comment;
import com.blogomat.blogomat.model.entities.Post;
import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.model.entities.dataObjects.FilterVO;
import com.blogomat.blogomat.model.entities.dataObjects.LikeItVO;
import com.blogomat.blogomat.services.CommentServiceImpl;
import com.blogomat.blogomat.services.LikeServiceImpl;
import com.blogomat.blogomat.services.PostServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/post")
public class PostController {
    private final PostServiceImpl postService;
    private final LikeServiceImpl likeService;
    private final CommentServiceImpl commentService;

    public PostController(PostServiceImpl postService, LikeServiceImpl likeService, CommentServiceImpl commentService) {
        this.postService = postService;
        this.likeService = likeService;
        this.commentService = commentService;
    }
/*
    @PostMapping(path = "/posts")
    public @ResponseBody
    Iterable<Post> getPosts(@RequestBody SearchCriteria) {
        return postService.getAllPosts();
    }*/

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

    @PostMapping(path = "/getComments")
    public @ResponseBody
    Iterable<Comment> getComments(@RequestBody Integer postID) {
        System.out.println("postID = " + postID);
        System.out.println("commentService posts= " + commentService.getComments(postID));
        return commentService.getComments(postID);
    }

    // @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/addComment")
    public @ResponseBody
    Comment addComment(@RequestBody Comment comment) {
        return commentService.add(comment);
    }
   /* @GetMapping(path = "/watch")
    public @ResponseBody
    String routeUserToChannelWithHyperlinkLink(@RequestParam int channelID) {
        return channelService.getChannelByChannelID(channelID).getHyperlink();
    }

    @GetMapping(path = "/allMovies")
    public @ResponseBody
    List<MovieDTO> allMovies() {
        return serverService.getAllMovies();
    }

    @GetMapping(path = "/allM")
    public @ResponseBody
    List<Movie> allM() {
        return serverService.findAll();
    }

    @GetMapping(path = "/allChannels")
    public @ResponseBody
    List<Channel> allChannels() {
        return channelService.getAllChannels();
    }

    @PostMapping(path = "/saveChannel")
    public @ResponseBody
    Channel saveChannel(@RequestBody Channel channel) {
        return channelService.save(channel);
    }

    @PostMapping(path = "/saveMovie")
    public @ResponseBody
    MovieDTO saveMovie(@RequestBody Movie movie) {

        return serverService.save(movie);
    }

    @PostMapping(path = "/updateMovie")
    public @ResponseBody
    Movie updateMovie(@RequestParam int channelID, @RequestParam int movieID, @RequestParam String startingTime) {
        Movie m = serverService.findMovieByMovieID(movieID);
        m.setStartAtTime(startingTime);
        m.setChannel(channelService.getChannelByChannelID(channelID));
        return serverService.saveFullMovie(m);
    }

    @PostMapping(path = "/updateChannel")
    public @ResponseBody
    Channel updateChannel(@RequestParam int channelID, @RequestParam int movieID, @RequestParam String startingTime) {
        Channel c = channelService.getChannelByChannelID(channelID);
        c.getPlaylist().add(serverService.findMovieByMovieID(updateMovie(channelID, movieID, startingTime).getMovieID()));
        return channelService.save(c);
    }

    @PostMapping(path = "/updateChannelHyperlink")
    public @ResponseBody
    Channel setChannelHyperlink(@RequestParam int channelID, @RequestParam String hyperlink) {
        Channel c = channelService.getChannelByChannelID(channelID);
        c.setHyperlink(hyperlink);
        return channelService.save(c);
    }

    @GetMapping(path = "/getMovieFilename")
    public @ResponseBody
    String getMovieFilename(@RequestParam int movieID) {
        return serverService.findMovieByMovieID(movieID).getFileName();
    }

    @PostMapping(path = "/deleteChannel")
    public @ResponseBody
    void deleteChannel(@RequestParam int channelID) {
        channelService.deleteChannelByChannelID(channelID);
    }

    @PostMapping(path = "/deleteMovie")
    public @ResponseBody
    void deleteMovie(@RequestParam int movieID) {
        serverService.deleteMovieByID(movieID);
    }*/
}
