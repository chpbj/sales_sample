package com.example.sales.member.repository;

import com.example.sales.member.domain.Member;
import com.example.sales.member.domain.MemberId;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by Administrator on 2017-06-11.
 */
public interface MemberRepository {

    List<Member> findAll() throws Exception;

    void insertMember(Member member) throws Exception;

    Member findById(MemberId id);
}
