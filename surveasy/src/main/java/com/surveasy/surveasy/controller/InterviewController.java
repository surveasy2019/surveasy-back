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
    @PostMapping("/interview/save")
    public String createJsonInterview(@RequestBody @Valid InterviewForm form, BindingResult bindingResult) {
        log.info("POST : Interview save");

        return validation(form, bindingResult);
    }

    @GetMapping("/interview/get/{nid}")
    public Interview interviewOne(@PathVariable("nid") Long nid) {
        log.info("Get : nid Interview");
        return interviewService.findOne(nid);
    }

    @GetMapping("/interview/get")
    public List<Interview> interviewAll() {
        log.info("Get : All Interview");
        return interviewService.findAll();
    }

    private String validation(InterviewForm form, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "인터뷰 주문 error";
        }

        Interview interview = new Interview();
        interview.setId(0L);
        interview.setTitle(form.getTitle());
        interview.setDescription(form.getDescription());
        interview.setPrice(form.getPrice());

        interviewService.save(interview);

        return "인터뷰 주문 완료";
    }
}
