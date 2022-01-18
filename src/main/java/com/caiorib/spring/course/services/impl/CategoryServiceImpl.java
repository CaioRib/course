package com.caiorib.spring.course.services.impl;

import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.repositories.CategoryRepository;
import com.caiorib.spring.course.services.CategoryService;
import com.caiorib.spring.course.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity findOne(Long id) {

        final CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if(Objects.isNull(category)) {
            throw new ObjectNotFoundException("Object with id " + id + " not found");
        }

        return category;
    }

    @Override
    public void createCategory(String name) {
        final CategoryEntity category = new CategoryEntity(null, name);
        categoryRepository.save(category);
    }
}
