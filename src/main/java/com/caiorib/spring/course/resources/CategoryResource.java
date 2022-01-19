package com.caiorib.spring.course.resources;

import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.dto.response.CategoryResponseBody;
import com.caiorib.spring.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryEntity> findOne(@PathVariable Long id) {
        return ResponseEntity.ok().body(categoryService.findOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<CategoryResponseBody>> findAll() {
        return ResponseEntity.ok().body(categoryService.findAll()
                .stream()
                .map(CategoryResponseBody::new)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryEntity category) {
        category = categoryService.createCategory(category);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryEntity category, @PathVariable Long id) {
        category.setId(id);
        categoryService.updateCategory(category);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }


}
