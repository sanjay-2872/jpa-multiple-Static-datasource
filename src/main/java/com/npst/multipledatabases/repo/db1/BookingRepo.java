package com.npst.multipledatabases.repo.db1;

import com.npst.multipledatabases.model.db1.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
}
