package com.example.Library.repository;

import com.example.Library.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
@Repository
public class ReservationRepository {
    private List<Reservation> reservationList;

    public ReservationRepository() {
        reservationList = new ArrayList<>();
    }

    public void add (Reservation reservation) {
        for (int i=0; i<reservationList.size(); i++) {
            if (reservationList.get(i).getId().equals(reservation.getId())) {
                throw new  IllegalArgumentException("Reservation already exists.");
            }
        }
        reservationList.add(reservation);
    }

    public void update (Reservation reservation) {
        for (int i=0; i<reservationList.size(); i++) {
            if (reservationList.get(i).getId().equals(reservation.getId())) {
                reservationList.set(i, reservation);
            }
        }
        throw new IllegalArgumentException("Reservation already exists.");
    }

    public List<Reservation> getList() {
        return reservationList;
    }

    public Reservation findById(String id) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getId().equals(id)) {
                return reservationList.get(i);
            }
        }
        return null;
    }

    public boolean delete(String id) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getId().equals(id)) {
                reservationList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Reservation findByMemberId(String memberId) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getMemberId().equals(memberId)) {
                return reservationList.get(i);
            }
        }
        return null;
    }

    public Reservation findByStatus(String status) {
        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getStatus().equals(status)) {
                return reservationList.get(i);
            }
        }
        return null;
    }
}
