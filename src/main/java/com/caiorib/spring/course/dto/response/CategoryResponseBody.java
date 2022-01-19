package com.caiorib.spring.course.dto.response;

import com.caiorib.spring.course.domain.CategoryEntity;

import java.io.Serializable;

public class CategoryResponseBody implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CategoryResponseBody() {
    }


    public CategoryResponseBody(CategoryEntity category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
