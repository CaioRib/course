package com.caiorib.spring.course.dto.request;

import com.caiorib.spring.course.domain.CategoryEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CategoryRequestBody implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(min = 5, max = 80, message = "O tamanho do nome deve ser entre {min} e {max} caracteres")
    private String name;

    public CategoryRequestBody() {
    }

    public CategoryRequestBody(CategoryEntity category) {
        this.name = category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity toCategoryEntity() {
        return new CategoryEntity(null, this.name);
    }
}
