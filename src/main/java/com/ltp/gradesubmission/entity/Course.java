package com.ltp.gradesubmission.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Table(name = "course")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject")
    @NonNull
    private String subject;

    @Column(name = "code",unique = true)
    @NonNull
    private String code;

    @Column(name = "description")
    @NonNull
    private String description; 

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Grade> grade;

    

}
