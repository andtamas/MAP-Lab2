package com.example.Library.service;
import com.example.Library.model.Reservation;
import com.example.Library.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
