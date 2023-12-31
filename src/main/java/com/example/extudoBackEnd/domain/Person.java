package com.example.extudoBackEnd.domain;

import com.example.extudoBackEnd.domain.enums.Perfil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Person {
    protected Integer id;
    protected String name, cpf, email, password;
    protected Set<Integer> perfis = new HashSet<>();
    protected LocalDate createdAt = LocalDate.now();
    public Person() {
        super();
        addPerfil(Perfil.CLIENT);
    }
    public Person(Integer id, String name, String cpf, String email, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Perfil> getPerfis() {
        return perfis.stream().map(code -> Perfil.toEnum(code)).collect(Collectors.toSet());
    }
    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCode());
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person pessoa = (Person) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(cpf, pessoa.cpf);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
