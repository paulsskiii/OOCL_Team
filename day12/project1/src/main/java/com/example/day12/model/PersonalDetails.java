package com.example.day12.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity marks this class as a JPA entity, meaning it corresponds to a table in the database.
@Entity
public class PersonalDetails {

    // @Id specifies the primary key of the entity.
    @Id
    // @GeneratedValue configures the way the primary key is generated (auto-increment in this case).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // These fields will be mapped to columns in the database table.
    private String firstName;
    private String lastName;
    private String middleName;
    private String occupation;
    private String email;
    private String telNumber;

    // Standard getters and setters for all the fields. These are used by Spring to
    // access and set the data from the form and the database.
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
 
