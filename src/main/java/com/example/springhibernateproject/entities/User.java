package com.example.springhibernateproject.entities;

import com.example.springhibernateproject.BillingInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name", nullable = false, length =60)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 65)
    private String lastName;

    @Column(nullable = false, unique = true, length =15)
    private String DNI;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "is_active")
    private Boolean isActive;

    @JsonIgnoreProperties("user")
    @OneToOne
    @JoinColumn(name="billing_info_id", unique=true)
    private BillingInfo billingInfo;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user")
    private List<Task> task = new ArrayList<>();

    public User() {}

    public User(Long id, String firstName, String lastName, String DNI, LocalDate birthDate, Boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DNI = DNI;
        this.birthDate = birthDate;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DNI='" + DNI + '\'' +
                ", birthDate=" + birthDate +
                ", isActive=" + isActive + '\n' +
                '}';
    }
}

