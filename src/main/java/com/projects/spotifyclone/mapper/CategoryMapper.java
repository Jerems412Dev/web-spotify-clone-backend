package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.CategoryDTO;
import com.projects.spotifyclone.entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);
    CategoryEntity fromCategoryDTO(CategoryDTO categoryDTO);
}
