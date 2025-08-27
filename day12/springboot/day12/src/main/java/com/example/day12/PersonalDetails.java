package com.example.day12;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// @Entity marks this class as a JPA entity, meaning it corresponds to a table in the database.
@Entity
@Data
@Table(name="personal_details")
public class PersonalDetails {

    // @Id specifies the primary key of the entity.
    @Id
    // @GeneratedValue configures the way the primary key is generated (auto-increment in this case).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // These fields will be mapped to columns in the database table.
    @Column(name="name")
    private String name;
    @Column(name="weight")
    private float weight;
    @Column(name="origin")
    private String origin;
    @Column(name="destination")
    private String destination;

   
}
 
