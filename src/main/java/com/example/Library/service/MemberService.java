package com.example.Library.service;

import com.example.Library.model.Library;
import com.example.Library.model.Member;
import com.example.Library.repository.LibraryRepository;
import com.example.Library.repository.MemberRepository;
import org.springframework.stereotype.Service;

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
        // Aceasta este esențială pentru ca membrul să apară în lista bibliotecii.
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

    public Member getById(Long id) {
        // Îmbunătățirea mesajului de excepție
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member with ID " + id + " not found"));
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}