package com.caiorib.spring.course.services;

import com.caiorib.spring.course.domain.CategoryEntity;

public interface CategoryService {

    CategoryEntity findOne(Long id);

}
