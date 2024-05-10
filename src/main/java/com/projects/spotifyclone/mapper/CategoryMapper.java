package com.projects.spotifyclone.mapper;

import com.projects.spotifyclone.dto.CategoryDTO;
import com.projects.spotifyclone.entity.CategoryEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryDTO toCategoryDTO(CategoryEntity categoryEntity);
    List<CategoryDTO> categoryEntityListToCategoryDTOList(List<CategoryEntity> list);
    List<CategoryEntity> categoryDTOListToCategoryEntityList(List<CategoryDTO> list);
    CategoryEntity fromCategoryDTO(CategoryDTO categoryDTO);
}
