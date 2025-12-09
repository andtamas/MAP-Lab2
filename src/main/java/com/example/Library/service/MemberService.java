package com.example.Library.service;
import com.example.Library.model.Member;
import com.example.Library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void add(Member member) {
        memberRepository.save(member);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> getById(Long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
