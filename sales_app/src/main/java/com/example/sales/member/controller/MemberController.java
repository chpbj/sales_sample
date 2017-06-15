package com.example.sales.member.controller;

import com.example.sales.member.domain.Member;
import com.example.sales.member.domain.MemberId;
import com.example.sales.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2017-06-11.
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberservice;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> list() throws Exception {
        return memberservice.findAll();
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member join(@RequestParam String id, @RequestParam String name) throws Exception {
        MemberId memberId = new MemberId(id);

        memberservice.insertMember(memberId, name);

        return memberservice.findById(memberId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Member view(@PathVariable String id) throws Exception {
        return memberservice.findById(new MemberId(id));
    }

    @Autowired
    public void setMemberservice(MemberService memberservice) {
        this.memberservice = memberservice;
    }
}
