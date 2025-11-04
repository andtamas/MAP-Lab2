package com.example.service;
import com.example.model.Reservation;
import com.example.repository.ReservationRepository;
import java.util.List;

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
