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

        return interview.getNid();
    }

    // 인터뷰 전체 조회
    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }

    // 인터뷰 1개 조회
    public Interview findOne(Long nid) {
        return interviewRepository.findOne(nid);
    }


//    // 인터뷰 1개 progress 변경
//    public Interview changeProgress(Long nid, Integer p) {
//        return interviewRepository.changeProgress(nid, p);
//    }
}
