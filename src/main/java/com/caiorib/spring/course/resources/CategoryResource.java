package com.caiorib.spring.course.resources;

import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> findONe(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestParam String name) {
        categoryService.createCategory(name);
        return ResponseEntity.ok().build();
    }
}
