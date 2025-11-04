package com.example.service;
import com.example.model.Member;
import com.example.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = new MemberRepository();
    }

    public void add(Member member) {
        memberRepository.add(member);
    }

    public void update(Member member) {
        memberRepository.update(member);
    }

    public List<Member> getAll() {
        return memberRepository.getList();
    }

    public Member getById(String id) {
        return memberRepository.findById(id);
    }

    public boolean delete(String id) {
        return memberRepository.delete(id);
    }

    public Member getByLibraryId(String id) {
        return memberRepository.findByLibraryId(id);
    }
}
