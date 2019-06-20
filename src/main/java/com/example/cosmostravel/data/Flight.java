package com.example.cosmostravel.data;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date departureDate;
    private Date arrivalDate;
    private Integer seatsCount;
    private Integer touristsCount;
    private Double ticketPrice;
}
