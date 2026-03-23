package com.gym.resource;

import com.gym.model.Member;
import com.gym.service.MemberService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MemberResource {

    @Inject
    MemberService memberService;

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
}