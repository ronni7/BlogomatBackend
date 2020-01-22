package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.PersonalDataSettings;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonalDataSettingsRepository extends CrudRepository<PersonalDataSettings, Integer> {
    Optional<PersonalDataSettings> findByUserID(Integer userID);
}
