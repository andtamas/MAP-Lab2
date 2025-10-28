package com.example.service;
import com.example.model.Member;
import com.example.repository.MemberRepository;

import java.util.List;

public class MemberService {
    private MemberRepository memberRepository;

    public MemberService (MemberRepository memberRepository) {
        this.memberRepository = new MemberRepository();
    }

    public void addMember(Member member) {
        memberRepository.add(member);
    }

    public void updateMember(Member member) {
        memberRepository.update(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.getList();
    }

    public Member getMemberById(String id) {
        if (memberRepository.findById(id)==null) {
            throw new  IllegalArgumentException("Member with ID " + id + " not found.");
        }
        return memberRepository.findById(id);
    }

    public boolean deleteMember(String id) {
        return memberRepository.delete(id);
    }
}
