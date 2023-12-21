package com.ltp.gradesubmission.coba;

import org.springframework.beans.factory.annotation.Autowired;

import com.ltp.gradesubmission.repository.StudentRepository;

public class B implements A {
  @Autowired
  StudentRepository studentRepository;
}
