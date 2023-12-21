package com.ltp.gradesubmission;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;

@SpringBootApplication
public class GradeSubmissionApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApplication.class, args);
		System.out.println("running");
	}

	@Override
	public void run(String... args) throws Exception {
		Student[] students=new Student[]{
			new Student("Dimas",LocalDate.parse("1994-06-29")),
			new Student("Hanafi",LocalDate.parse("1993-12-06")),
			new Student("Aji",LocalDate.parse("1994-06-29")),
		};

		for (int i = 0; i < students.length; i++) {
			studentRepository.save(students[i]);
		}

		Course[] courses=new Course[]{
			new Course("Math","Mat-111","This is course math."),
			new Course("English","Eng-111","This is course english."),
			new Course("Programing","Pro-111","This is course programing."),
		};

		for (int i = 0; i < courses.length; i++) {
			courseRepository.save(courses[i]);
		}
	}

}
