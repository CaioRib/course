package com.caiorib.spring.course.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class StateEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "IDT_STATE")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAM_STATE")
    private String nome;

    @OneToMany(mappedBy = "state")
    @JsonBackReference
    private List<CityEntity> cities;

    public StateEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.cities = new ArrayList<>();
    }

    public StateEntity() {
        this.cities = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CityEntity> getCities() {
        return cities;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateEntity that = (StateEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
