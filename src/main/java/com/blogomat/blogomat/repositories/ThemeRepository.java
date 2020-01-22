package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ThemeRepository extends CrudRepository<Theme, Integer> {
    Optional<Theme> findByUserID(Integer userID);
}
