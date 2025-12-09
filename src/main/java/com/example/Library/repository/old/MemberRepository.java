package com.example.Library.repository.old;

import com.example.Library.model.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends InFileRepository<Member> {
    public MemberRepository() {
        super("src/main/resources/data/members.json", Member.class);
    }
}
