// andtamas/map-lab2/MAP-Lab2-1dd802d241fb9490adc2ace817a2860f83c27d8a/src/main/java/com/example/Library/model/Member.java

package com.example.Library.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    private String name;
    private String email;

    // Câmp utilitar pentru a prelua ID-ul din formular (nu este mapat direct în baza de date)
    @Transient
    private Long libraryId;

    // Relația ManyToOne cu Library
    @ManyToOne
    @JoinColumn(name = "library_fk") // Numele coloanei cheie străină în tabela 'members'
    private Library library;

    // Relația OneToMany cu Loan
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Loan> loans = new HashSet<>();

    // Relația OneToMany cu Reservation
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations = new HashSet<>();


    // --- Constructors ---

    public Member() {
    }

    public Member(String name, String email, Library library) {
        this.name = name;
        this.email = email;
        this.setLibrary(library); // Folosește setter-ul pentru a stabili legătura bidirecțională
    }

    public Member(Long id, String name, String email, Library library) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.setLibrary(library);
    }

    // --- Loans Management (Utilities) ---

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.setMember(this);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.setMember(null);
    }

    // --- Reservations Management (Utilities) ---

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        reservation.setMember(this);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setMember(null);
    }


    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Library getLibrary() {
        return library;
    }

    // Setter esențial: actualizează legătura bidirecțională
    public void setLibrary(Library library) {
        if (this.library != null) {
            this.library.getMembers().remove(this);
        }
        this.library = library;
        if (library != null) {
            library.getMembers().add(this);
        }
        // Actualizează câmpul transient pentru compatibilitatea cu formularele/controlerul
        this.libraryId = (library != null) ? library.getId() : null;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    // Setter pentru câmpul transient, folosit la binding-ul din formular
    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
        // NOTA: Legătura JPA (this.library) va fi setată în MemberService
        // folosind acest ID înainte de salvare.
    }

    public Set<Loan> getLoans() {
        return loans;
    }

    public void setLoans(Set<Loan> loans) {
        this.loans = loans;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}