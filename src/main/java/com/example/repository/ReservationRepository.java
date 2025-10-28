package com.example.repository;

import com.example.model.Reservation;

import java.util.List;
import java.util.ArrayList;

public class ReservationRepository {
    private List<Reservation> reservationList;

    public ReservationRepository() {
        reservationList = new ArrayList<>();
    }

    public void save (Reservation reservation) {
        for (int i=0; i<reservationList.size(); i++) {
            if (reservationList.get(i).getId().equals(reservation.getId())) {
                reservationList.set(i, reservation);
            }
        }
        reservationList.add(reservation);
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
