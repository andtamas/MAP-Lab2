package com.example.Library.repository;

import com.example.Library.model.Reservation;
import com.example.Library.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByStatus(ReservationStatus status);

    List<Reservation> findByMember_Id(Long memberId);

    List<Reservation> findByStatusAndMember_Id(ReservationStatus status, Long memberId);
}