package com.example.sales.member.service;

import com.example.sales.member.domain.Member;
import com.example.sales.member.domain.MemberId;
import com.example.sales.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017-06-11.
 */
@Service
public class MemberService {

    private MemberRepository memberRepository;

    public List<Member> findAll() throws Exception {
        return memberRepository.findAll();
    }

    @Transactional
    public void insertMember(MemberId id, String name) throws Exception {
        memberRepository.insertMember(new Member(id, name));
    }

    public Member findById(MemberId id) {
        return memberRepository.findById(id);
    }

    @Autowired
    public void setMemberRepository(MemberRepository memberRepositoryM) {
        this.memberRepository = memberRepositoryM;
    }
}
