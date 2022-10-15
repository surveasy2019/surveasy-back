package com.surveasy.surveasy.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class InterviewForm {

//    private String dueDate;
//    private String dueTime;
//    private Integer spentTime;
//    private Boolean type;
//    private Integer typeOnline;
//    private String typeInput;
//    private Integer requirementHeadCount;
//    private Integer targetingGender;
//    private Integer targetingAge;
//
//    private String requirementOne;
//    private String requirementTwo;
//    private String requirementThree;
//
//    private String preferenceOne;
//    private String preferenceTwo;
//    private String preferenceThree;
//
//    private Integer identity;
//    private Integer priceOriginal;

    @NotEmpty(message = "제목은 필수입니다.")
    private String title;
    private String description;
//    private String etcRequirement;
//    private String duration;
//    private Boolean scheduleType;
    private Integer price;
//    private String accountOwner;


}