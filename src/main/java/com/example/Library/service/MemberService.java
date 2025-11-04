package com.example.Library.service;
import com.example.Library.model.Member;
import com.example.Library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
