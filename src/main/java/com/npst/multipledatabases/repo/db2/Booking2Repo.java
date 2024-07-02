package com.npst.multipledatabases.repo.db2;


import com.npst.multipledatabases.model.db2.Booking2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking2Repo extends JpaRepository<Booking2,Long> {
}
