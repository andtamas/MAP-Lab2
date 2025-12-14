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
        Library library = libraryRepository.findById(libraryId)
                .orElseThrow();

        Member member = new Member(name, email, library);
        memberRepository.save(member);
    }

    public void update(Long id, String name, String email) {
        Member member = memberRepository.findById(id)
                .orElseThrow();

        member.setName(name);
        member.setEmail(email);
        // version e gestionat automat
    }

    public Member getById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
