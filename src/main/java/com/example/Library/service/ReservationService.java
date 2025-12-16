package com.example.Library.service;
import com.example.Library.model.Reservation;
import com.example.Library.model.ReservationStatus;
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

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getFiltered(ReservationStatus status, Long memberId) {
        if (status != null && memberId != null) {
            return reservationRepository.findByStatusAndMember_Id(status, memberId);
        } else if (status != null) {
            return reservationRepository.findByStatus(status);
        } else if (memberId != null) {
            return reservationRepository.findByMember_Id(memberId);
        } else {
            return reservationRepository.findAll();
        }
    }

    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}