package com.blogomat.blogomat.repositories;

import com.blogomat.blogomat.model.entities.Comment;
import com.blogomat.blogomat.model.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
