package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.Post;
import com.blogomat.blogomat.model.entities.PostReport;
import com.blogomat.blogomat.model.VO.FilterVO;
import com.blogomat.blogomat.repositories.PostRepository;
import com.blogomat.blogomat.repositories.ReportRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ReportRepository reportRepository;
    private LikeServiceImpl likeService;

    public PostServiceImpl(PostRepository postRepository, ReportRepository reportRepository, LikeServiceImpl likeService) {
        this.postRepository = postRepository;
        this.reportRepository = reportRepository;
        this.likeService = likeService;
    }

    @Override
    public Iterable<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post add(Post post) {
        return postRepository.save(post);
    }

    @Override
    public PostReport reportPost(PostReport report) {
        return reportRepository.save(report);
    }

    @Override
    public Iterable<Post> getAllPostsSorted(String sort, String order) {
        return postRepository.findAll(Sort.by(order.toUpperCase().equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sort));
    }

    @Override
    public Iterable<Post> getAllPostsSortedByLikes() {
        List<Post> list = (List<Post>) postRepository.findAll();
        Map<Post, Integer> map = new HashMap<>();
        list.forEach(post -> map.put(post, likeService.getLikes(post.getId())));
          Map<Post, Integer> result = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, LinkedHashMap::new));
        List<Post> resultList = new ArrayList<>(result.keySet());
        Collections.reverse(resultList);
        return resultList;

    }

    @Override
    public Iterable<Post> getAllPostsSorted(FilterVO filterVO) {
        return postRepository.findAll(Sort.by(filterVO.getOrder().toUpperCase().equals("ASC") ? Sort.Direction.ASC :
                Sort.Direction.DESC, filterVO.getSort()));
// search criteria

    }

    @Override
    public Iterable<Post> getAuthorPosts(String username) {
        return postRepository.findAllByAuthor(username);
    }

    @Override
    public Optional<Post> getPostByID(Integer postID) {
        return postRepository.findById(postID);
    }

}
