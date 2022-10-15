package com.surveasy.surveasy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Interview {

    @Id @GeneratedValue
    private Long nid;
    private Long id;    // lastCheckedId
//    private String uploader;
//    private Integer progress;
//
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


    private String title;
    private String description;
//    private String etcRequirement;
//    private String duration;
//    private Boolean scheduleType;
    private Integer price;
//    private String accountOwner;

}
