package com.blogomat.blogomat.services;

import com.blogomat.blogomat.model.entities.Like;
import com.blogomat.blogomat.repositories.LikeRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    @Override
    public int getLikes(int postID) {
        Optional<Like> l = likeRepository.findByPostID(postID);
        return l.map(like -> like.getUsersLiked().size()).orElse(-1);
    }

    @Override
    public boolean like(int postID, int userID) {

        Optional<Like> l = likeRepository.findByPostID(postID);
        if (l.isPresent()) {
            Like like = l.get();
            like.getUsersLiked().add(userID);
            likeRepository.save(like);
            return true;
        }
        return false;
    }
}
