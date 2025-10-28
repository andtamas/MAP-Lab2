package com.example.repository;

import com.example.model.Library;
import com.example.model.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private List<Member> memberList;

    public MemberRepository() {
        memberList = new ArrayList<Member>();
    }

    public void add(Member member) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(member.getId())) {
                throw new IllegalArgumentException("Library already exists");
            }
        }
        memberList.add(member);
    }

    public void update(Member member) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(member.getId())) {
                memberList.set(i, member);
                return;
            }
        }
        throw new IllegalArgumentException("Library not found.");
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
        throw new  IllegalArgumentException("Member not found.");
    }

    public boolean delete (String id) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getId().equals(id)) {
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
