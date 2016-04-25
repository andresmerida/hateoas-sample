package com.sample.hateoas.core.repositories;

import com.sample.hateoas.core.entities.Locality;
import com.sample.hateoas.core.entities.LocalityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Administrador on 25/04/2016.
 */

public interface LocalityRepository extends JpaRepository<Locality, LocalityPK> {

    @Query(value = "SELECT IFNULL(MAX(localityid), 0) + 1 FROM locality",nativeQuery = true)
    Integer getMaxId();
}
