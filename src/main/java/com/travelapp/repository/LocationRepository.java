package com.travelapp.repository;
import com.travelapp.model.Category;
import com.travelapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(String name);
    List<Location> findAllByCategoriesContaining(Category category);
}
