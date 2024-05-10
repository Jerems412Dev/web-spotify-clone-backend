package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.CategoryDTO;
import com.projects.spotifyclone.mapper.CategoryMapper;
import com.projects.spotifyclone.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    // add new category
    @Transactional
    public String createCategory(CategoryDTO category) {
        categoryRepository.save(categoryMapper.fromCategoryDTO(category));
        return "category added successfully";
    }

    // add categories
    @Transactional
    public String createCategories(List<CategoryDTO> categories) {
        categoryRepository.saveAll(categoryMapper.categoryDTOListToCategoryEntityList(categories));
        return "categories added successfully";
    }

    // find category by name
    @Transactional(readOnly = true)
    public CategoryDTO findByNameCategory(String nameCategory) {
        return categoryMapper.toCategoryDTO(categoryRepository.findByNameCategory(nameCategory));
    }

    // find category by id
    @Transactional(readOnly = true)
    public CategoryDTO findByIdCategory(long idCategory) {
        return categoryMapper.toCategoryDTO(categoryRepository.findByIdCategory(idCategory));
    }

    // returns a list of album categories
    @Transactional(readOnly = true)
    public List<CategoryDTO> findByTitleAlbum(String titleAlbum) {
        return categoryMapper.categoryEntityListToCategoryDTOList(categoryRepository.findDistinctByAlbumsTitleAlbum(titleAlbum));
    }

    // returns a list of artist categories
    @Transactional(readOnly = true)
    public List<CategoryDTO> findByNameArtist(String nameArtist) {
        return categoryMapper.categoryEntityListToCategoryDTOList(categoryRepository.findDistinctByArtistsNameArtist(nameArtist));
    }

    // returns a list of SpotifyPlaylist categories
    @Transactional(readOnly = true)
    public List<CategoryDTO> findByNamePlaylist(String namePlaylist) {
        return categoryMapper.categoryEntityListToCategoryDTOList(categoryRepository.findDistinctBySpotifyplaylistsNamePlaylist(namePlaylist));
    }

    // check if an SpotifyPlaylist exists.
    @Transactional(readOnly = true)
    public Boolean categoryExist(String categoryName) {
        return categoryRepository.existsByNameCategory(categoryName);
    }

}
