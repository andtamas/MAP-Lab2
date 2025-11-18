package com.example.Library.service;
import com.example.Library.model.Reservation;
import com.example.Library.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void add(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void update(Reservation reservation) {
        reservationRepository.update(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(String id) {
        return reservationRepository.findById(id);
    }

    public void delete(String id) {
        reservationRepository.delete(id);
    }
}
