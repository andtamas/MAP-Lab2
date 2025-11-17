package com.example.Library.repository;

import com.example.Library.model.Reservation;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository extends InFileRepository<Reservation> {
    public ReservationRepository() {
        super("src/main/resources/data/reservations.json", Reservation.class);
    }
}
