package com.example.Library.controller;

import com.example.Library.model.Reservation;
import com.example.Library.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAll());
        return "reservation/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation/form";
    }

    @PostMapping
    public String createReservation(@ModelAttribute Reservation reservation) {
        reservationService.add(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/{id}/detail")
    public String viewReservation(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.getById(id));
        return "reservation/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Reservation> reservation = reservationService.getById(id);
        model.addAttribute("reservation", reservation);
        return "reservation/form";
    }

    // Process update
    @PostMapping("/{id}/edit")
    public String updateReservation(@PathVariable Long id, @ModelAttribute Reservation reservation) {
        reservation.setId(id);
        reservationService.update(reservation);
        return "redirect:/reservations";
    }

    @PostMapping("/{id}/delete")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.delete(id);
        return "redirect:/reservations";
    }
}
