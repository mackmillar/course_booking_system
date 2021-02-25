package com.codeclan.example.coursebooking.repositories;

import com.codeclan.example.coursebooking.models.Booking;
import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    //Get all bookings for a given date
    List<Booking> findByDate(String date);

    //Get all cutomers for a given course
}