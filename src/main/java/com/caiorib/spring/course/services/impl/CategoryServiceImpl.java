package com.caiorib.spring.course.services.impl;

import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.repositories.CategoryRepository;
import com.caiorib.spring.course.services.CategoryService;
import com.caiorib.spring.course.services.exceptions.DataIntegrityException;
import com.caiorib.spring.course.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity findOne(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity updatedCategory) {
        final CategoryEntity category = findOne(updatedCategory.getId());
        category.setName(updatedCategory.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        findOne(id);
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Cannot delete a category which has products.", e);

        }
    }

    @Override
    public Page<CategoryEntity> findPaged(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return categoryRepository.findAll(pageRequest);

    }


}
