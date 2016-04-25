package com.sample.hateoas.core.repositories;

import com.sample.hateoas.core.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by andresmerida on 4/13/2016.
 */
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
