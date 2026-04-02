package com.gym.service;

import com.gym.model.Member;
import com.gym.model.WorkoutPlan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MemberService {

    @Transactional
    public Member addMember(Member member) {
        member.persist();

        if (member.workoutPlans != null) {
            for (WorkoutPlan wp : member.workoutPlans) {
                wp.member = member;
                wp.persist();
            }
        }

        return member;
    }

    public List<Member> getMembers() {
        return Member.listAll();
    }

    public Member getMemberById(Long id) {
        return Member.findById(id);
    }

    public Member getMemberByEmail(String email) {
        return Member.find("email", email).firstResult();
    }

    public List<WorkoutPlan> getWorkoutPlansByMemberId(Long id) {
        return WorkoutPlan.list("member.id", id);
    }
}