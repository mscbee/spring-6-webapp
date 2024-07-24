package com.cb.learning.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //this id is what is going to persist each author object into the database
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy =  "authors")
    // using a set as you can't have duplicate elements - each must be unique
    private Set<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long authorId) {
        id = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBook(Set<Book> books) {
        this.books = books;
    }


    // this was generated using command + n and only using the id field to determine equity

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

