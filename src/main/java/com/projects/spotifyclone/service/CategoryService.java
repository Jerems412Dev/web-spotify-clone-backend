package com.projects.spotifyclone.service;

import com.projects.spotifyclone.mapper.CategoryMapper;
import com.projects.spotifyclone.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

}
