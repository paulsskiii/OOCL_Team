package com.example.miniproject_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AllCustomer extends Customers{

    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="full_name")
    private String fullName;

    @Column(name="contact_number")
    private String contactNumber;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="full_address")
    private String fullAddress;
    
    public AllCustomer (){}

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getFullAddress() {
        return fullAddress;
    }
    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
