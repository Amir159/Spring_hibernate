package com.syncretis.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language", schema = "publisher")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(schema = "publisher", name = "persons_languages",
            joinColumns = @JoinColumn(name = "language_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> personList;

    public Language() {
    }

    public Language(String name) {
        this.name = name;
    }

    public Language(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id = " + id +
                ", name = '" + name + '\'' + personList +
                '}';
    }
}