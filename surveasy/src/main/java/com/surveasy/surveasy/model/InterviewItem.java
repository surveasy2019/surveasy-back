package com.surveasy.surveasy.model;

import com.surveasy.surveasy.domain.interviewitem.FixedStatus;
import com.surveasy.surveasy.domain.interviewitem.ParticipatedStatus;
import com.surveasy.surveasy.domain.interviewitem.SentStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class InterviewItem {

    @Id
    @GeneratedValue
    @Column(name = "interview_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_nid")
    private Interview interview;

    private String date;
    private String time;

    private String interviewee_name;
    private String interviewee_email;
    private String interviewee_phone;
    private String submitTime;

    private String answer1;
    private String answer2;
    private String answer3;

    @Enumerated(EnumType.STRING)
    private FixedStatus fixed; // 선정상태 [O, X, YET]

    @Enumerated(EnumType.STRING)
    private ParticipatedStatus participated; // 참석상태 [O, X, YET]

    @Enumerated(EnumType.STRING)
    private SentStatus sent;  // 정산상태 [O, X, YET]
}
