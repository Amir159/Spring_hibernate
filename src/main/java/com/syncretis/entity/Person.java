package com.syncretis.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "person", schema = "publisher")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    private LocalDate birthday;

    @ManyToOne()
    @JoinColumn(name = "department_id")
    @NotNull
    private Department department;

    public Person() {
    }

    public Person(String firstName, String secondName, LocalDate birthday, Department department) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.department = department;
    }

    public Person(long id, String firstName, String secondName, LocalDate birthday, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", secondName = '" + secondName + '\'' +
                ", birthday = " + birthday +
                ", " + department +
                '}';
    }
}
