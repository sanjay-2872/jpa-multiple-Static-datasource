package com.npst.multipledatabases.service;


import com.npst.multipledatabases.repo.db2.Booking2Repo;
import com.npst.multipledatabases.model.db1.Booking;

import com.npst.multipledatabases.repo.db1.BookingRepo;
import com.npst.multipledatabases.model.db2.Booking2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookingSevice {


    private final BookingRepo bookingRepo;
    private final Booking2Repo bookingRepo2;

    @Autowired
    BookingSevice( BookingRepo bookingRepo, Booking2Repo bookingRepo2){
        this.bookingRepo=bookingRepo;
        this.bookingRepo2=bookingRepo2;
    }

    public List<Object> getBookingDetails(){
        List<Booking>  repo1Bookings = bookingRepo.findAll();
        log.info("Repo 1 Booking Data :: {}", repo1Bookings);

        List<Booking2>  repo2Bookings = bookingRepo2.findAll();
        log.info("Repo 2 Booking Data :: {}", repo2Bookings);

        List<Object> response = new ArrayList<>(repo2Bookings);
        log.info("Added Repo 2 Booking data to response :: {}", response);
        response.addAll(repo1Bookings);
        log.info("Added Repo 1 Booking Data to response :: {}", response);

       return response;
    }
}
