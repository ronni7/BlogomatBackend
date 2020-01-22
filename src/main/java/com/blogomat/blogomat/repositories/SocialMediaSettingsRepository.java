package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.SocialMediaSettings;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SocialMediaSettingsRepository extends CrudRepository<SocialMediaSettings, Integer> {
    Optional<SocialMediaSettings> findByUserID(Integer userID);

}
