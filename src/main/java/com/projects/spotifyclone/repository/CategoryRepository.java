package com.projects.spotifyclone.repository;

import com.projects.spotifyclone.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByNameCategory(String categoryName);
    Boolean existsByNameCategory(String categoryName);
}
