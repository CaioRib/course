package com.caiorib.spring.course.resources;

import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.dto.request.CategoryRequestBody;
import com.caiorib.spring.course.dto.response.CategoryResponseBody;
import com.caiorib.spring.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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

    @GetMapping
    public ResponseEntity<List<CategoryResponseBody>> findAll() {
        return ResponseEntity.ok().body(categoryService.findAll()
                .stream()
                .map(CategoryResponseBody::new)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryRequestBody categoryRequestBody) {
        final CategoryEntity category = categoryService.createCategory(categoryRequestBody.toCategoryEntity());
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCategory(@Valid @RequestBody CategoryRequestBody categoryRequestBody, @PathVariable Long id) {
        final CategoryEntity category = categoryRequestBody.toCategoryEntity();
        category.setId(id);
        categoryService.updateCategory(category);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<CategoryResponseBody>> findAllPaged(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "24") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        final Page<CategoryResponseBody> categories = categoryService.findPaged(page, size, orderBy, direction).map(CategoryResponseBody::new);

        return ResponseEntity.ok().body(categories);
    }

}
