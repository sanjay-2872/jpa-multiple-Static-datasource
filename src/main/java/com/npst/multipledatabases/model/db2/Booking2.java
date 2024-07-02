package com.npst.multipledatabases.model.db2;



import jakarta.persistence.*;
import lombok.Data;


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
}
