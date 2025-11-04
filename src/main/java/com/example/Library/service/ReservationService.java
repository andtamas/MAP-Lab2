package com.example.Library.service;
import com.example.Library.model.Reservation;
import com.example.Library.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = new ReservationRepository();
    }

    public void add(Reservation reservation) {
        reservationRepository.add(reservation);
    }

    public void update(Reservation reservation) {
        reservationRepository.update(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getList();
    }

    public Reservation getById(String id) {
        return reservationRepository.findById(id);
    }

    public boolean delete(String id) {
        return reservationRepository.delete(id);
    }

    public Reservation getByUserId(String userId) {
        return reservationRepository.findByMemberId(userId);
    }

    public Reservation getByStatus(String status) {
        return reservationRepository.findByStatus(status);
    }
}
