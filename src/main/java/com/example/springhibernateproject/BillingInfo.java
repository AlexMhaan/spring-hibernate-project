package com.example.springhibernateproject;

import com.example.springhibernateproject.entities.User;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "billing_info")
public class BillingInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 45)
    private String street;

    @Column(length = 30)
    private String postalCode;

    @Column(length = 40)
    private String city;

    @Column(length = 40)
    private String country;

    @Column(length = 50)
    private String iban;

    @OneToOne(mappedBy = "billingInfo")
    private User user;


    public BillingInfo() {
    }

    public BillingInfo(Long id, String street, String postalCode, String city, String country, String iban, User user) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.iban = iban;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BillingInfo{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", iban='" + iban + '\n' +
                '}';
    }
}
