package com.gym.service;

import com.gym.model.Member;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MemberService {

    @Transactional
    public Member addMember(Member member) {
        member.persist();
        return member;
    }

    public List<Member> getMembers() {
        return Member.listAll();
    }
}