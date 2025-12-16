package com.example.Library.service;

import com.example.Library.model.Library;
import com.example.Library.model.Member;
import com.example.Library.repository.LibraryRepository;
import com.example.Library.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final LibraryRepository libraryRepository;

    public MemberService(MemberRepository memberRepository,
                         LibraryRepository libraryRepository) {
        this.memberRepository = memberRepository;
        this.libraryRepository = libraryRepository;
    }

    public void create(String name, String email, Long libraryId) {

        // 1. Găsește entitatea gestionată Library
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow(() -> new RuntimeException("Library with ID " + libraryId + " not found"));

        // 2. Crează membrul cu entitatea Library găsită
        Member member = new Member(name, email, library);

        // 3. Stabilește relația bidirecțională (Library -> Member)
        library.addMember(member);

        // 4. Salvează membrul
        memberRepository.save(member);
    }

    public void update(Long id, String name, String email) {
        // Obține membrul existent
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member with ID " + id + " not found"));

        // Actualizează câmpurile
        member.setName(name);
        member.setEmail(email);

        // Salvează explicit (gestionează și actualizarea câmpului @Version)
        memberRepository.save(member);
    }

    // NOUĂ METODĂ DE FILTRARE
    @Transactional(readOnly = true)
    public List<Member> getFiltered(Long id, String name, Long libraryId) {
        // Curățare filtru Nume
        String nameFilter = (name != null && !name.trim().isEmpty()) ? name.trim() : null;

        // Dacă nu este aplicat niciun filtru, returnează toți membrii cu fetch eager
        if (id == null && nameFilter == null && libraryId == null) {
            return memberRepository.findAllWithLibrary();
        }

        // Altfel, folosește interogarea filtrată din Repository
        return memberRepository.findFiltered(id, nameFilter, libraryId);
    }

    @Transactional(readOnly = true)
    public Member getById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member with ID " + id + " not found"));
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    // Metoda getAll este menținută, dar listMembers din Controller folosește acum getFiltered.
    public List<Member> getAll() {
        return memberRepository.findAll();
    }
}