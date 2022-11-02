package com.surveasy.surveasy.controller;

import com.surveasy.surveasy.model.Interview;
import com.surveasy.surveasy.service.InterviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InterviewController {

    private final InterviewService interviewService;

    // 인터뷰 주문
    @PostMapping("/interview/add")
    public String createJsonInterview(@RequestBody @Valid InterviewForm form, BindingResult bindingResult) {
        log.info("POST : Interview save");

        return validation(form, bindingResult);
    }

    // 인터뷰 전체 조회
    @GetMapping("/adminmain/interview/all")
    public List<Interview> interviewAll() {
        log.info("Get : All Interview");
        return interviewService.findAll();
    }

    // 인터뷰 1개 조회
    @GetMapping("/adminmain/interview/{nid}")
    public Interview interviewOne(@PathVariable("nid") Long nid) {
        log.info("Get : nid Interview");
        return interviewService.findOne(nid);
    }

//    // 인터뷰 1개 progress 변경
//    @GetMapping("/adminmain/interview/{nid}/{p}")
//    public Interview interviewProgress(@PathVariable("nid") Long nid, @PathVariable("p") Integer p) {
//        log.info("GET : Progress Change");
//        return interviewService.changeProgress(nid, p);
//    }



    // Form Validation 판단
    private String validation(InterviewForm form, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "인터뷰 주문 error";
        }

        Interview interview = new Interview();
        interview.setId(0L);
        interview.setProgress(0);

        interview.setRequirementHeadCount(form.getRequirementHeadCount());
        interview.setTargetingGender(form.getTargetingGender());

        interview.setTitle(form.getTitle());
        interview.setDescription(form.getDescription());

        interview.setPrice(form.getPrice());
        interview.setAccountOwner(form.getAccountOwner());

        interviewService.save(interview);

        return "인터뷰 주문 완료";
    }
}
