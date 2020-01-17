package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.ContactMessage;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactMessage, Integer> {

}
