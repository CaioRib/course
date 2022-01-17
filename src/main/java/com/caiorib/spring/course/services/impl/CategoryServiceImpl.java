package com.caiorib.spring.course.services.impl;

import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.repositories.CategoryRepository;
import com.caiorib.spring.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity findOne(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void createCategory(String name) {
        final CategoryEntity category = new CategoryEntity(null, name);
        if(Objects.isNull(category)) {

        }
        categoryRepository.save(category);
    }
}
