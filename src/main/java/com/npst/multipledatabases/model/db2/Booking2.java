package com.npst.multipledatabases.model.db2;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;

import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "booking")
public class Booking2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "drop_address")
    private String dropAddress;

    @Column(name = "booking_amount")
    private String bookingAmount;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "drop_data")
    private LocalDateTime dropData;
}
