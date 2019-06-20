package com.example.cosmostravel.data;

import com.example.cosmostravel.enums.Gender;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String country;
    private String notes;
    private Date birthDate;
    @OneToMany
    private Set<Flight> flights = new HashSet<>();


    public Tourist() {}

    public Tourist(String firstName, String lastName, Gender gender, String country, String notes, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.country = country;
        this.notes = notes;
        this.birthDate = birthDate;
    }
}
