package com.surveasy.surveasy.service;

import com.surveasy.surveasy.model.Interview;
import com.surveasy.surveasy.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;

    // 인터뷰 주문
    @Transactional
    public Long save(Interview interview) {
        interviewRepository.save(interview);

        return interview.getId();
    }

    // 1개 조회
    public Interview findOne(Long nid) {
        return interviewRepository.findOne(nid);
    }


    // 전체 조회
    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }
}
