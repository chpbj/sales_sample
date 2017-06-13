package com.example.sales.member.repository;

import com.example.sales.member.domain.Member;
import com.example.sales.member.domain.MemberId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Administrator on 2017-06-11.
 */
@Repository
public class JpaMemberRepository implements MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> findAll() throws Exception {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
        Root<Member> root = criteriaQuery.from(Member.class);

        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("dt")), criteriaBuilder.asc(root.get("id")));

        TypedQuery<Member> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public void insertMember(Member member) throws Exception {
        entityManager.persist(member);
    }

    @Override
    public Member findById(MemberId id) {
        return entityManager.find(Member.class, id);
    }
}
