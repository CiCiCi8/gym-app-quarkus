package com.gym.resource;

import com.gym.model.Member;
import com.gym.model.WorkoutPlan;
import com.gym.service.MemberService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemberResource {

    @Inject
    MemberService memberService;

    @RolesAllowed("admin")
    @GET
    @Path("getmembers")
    public List<Member> getMembers() {
        return memberService.getMembers();
    }

    @POST
    @Path("addmember")
    public Member addMember(Member member) {
        return memberService.addMember(member);
    }

    @GET
    @Path("member/{id}")
    public Member getMemberById(@PathParam("id") Long id) {
        return memberService.getMemberById(id);
    }

    @GET
    @Path("member-by-email")
    public Member getMemberByEmail(@QueryParam("email") String email) {
        return memberService.getMemberByEmail(email);
    }

    @GET
    @Path("member/{id}/workoutplans")
    public List<WorkoutPlan> getWorkoutPlans(@PathParam("id") Long id) {
        return memberService.getWorkoutPlansByMemberId(id);
    }
}