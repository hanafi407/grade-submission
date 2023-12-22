package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    public Course getCourse(Long id) {
        Optional<Course> course= courseRepository.findById(id);
        return unwrapCourse(course, id);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    } 

    public void deleteCourse(Long id) {
        courseRepository.delete(getCourse(id));        
    }

    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public static Course unwrapCourse(Optional<Course> entity, Long id){
        if(entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }

}
