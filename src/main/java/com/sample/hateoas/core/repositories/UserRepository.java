package com.sample.hateoas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.hateoas.core.entities.User;

/**
 * Created by andresmerida on 4/4/2016.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
