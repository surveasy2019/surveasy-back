package com.surveasy.surveasy.repository;

import com.surveasy.surveasy.model.Interview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InterviewRepository {

    private final EntityManager em;

    // 인터뷰 주문
    public void save(Interview interview) {
        em.persist(interview);
    }

    // 1개 조회
    public Interview findOne(Long nid) {
        return em.find(Interview.class, nid);
    };

    // 전체 조회
    public List<Interview> findAll() {

        List<Interview> interviewList = null;

        interviewList = em.createQuery(
                "select i from Interview i where i.nid > 0" , Interview.class)
                    .getResultList();

        return interviewList;
    }
}
