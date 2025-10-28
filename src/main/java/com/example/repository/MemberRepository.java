package com.example.repository;

import com.example.model.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member> memberList;

    public MemberRepository() {
        memberList = new ArrayList<Member>();
    }

    public void save(Member member) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(member.getId())) {
                memberList.set(i, member);
                return;
            }
        }
        memberList.add(member);
    }

    public List<Member> getList() {
        return memberList;
    }

    public Member findById(String id) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(id)) {
                return memberList.get(i);
            }
        }
        return null;
    }

    public boolean delete (Member member) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(member.getId())) {
                memberList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Member findByLibraryId(String id) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getLibraryId().equals(id)) {
                return memberList.get(i);
            }
        }
        return null;
    }

}
