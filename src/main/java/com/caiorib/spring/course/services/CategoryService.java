package com.caiorib.spring.course.services;

import com.caiorib.spring.course.domain.CategoryEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    CategoryEntity findOne(Long id);

    List<CategoryEntity> findAll();

    CategoryEntity createCategory(CategoryEntity categoryEntity);

    CategoryEntity updateCategory(CategoryEntity categoryEntity);

    void deleteCategory(Long id);

    Page<CategoryEntity> findPaged(Integer page, Integer size, String orderBy, String direction);

}
