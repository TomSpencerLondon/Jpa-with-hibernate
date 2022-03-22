package com.example.jpawithhibernate;

import com.example.jpawithhibernate.entity.Course;
import com.example.jpawithhibernate.entity.Review;
import com.example.jpawithhibernate.entity.Student;
import com.example.jpawithhibernate.repository.CourseRepository;
import com.example.jpawithhibernate.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaWithHibernateApplication implements CommandLineRunner {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private StudentRepository studentRepository;

  public static void main(String[] args) {
    SpringApplication.run(JpaWithHibernateApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
//    studentRepository.saveStudentWithPassport();
//    courseRepository.addHardcodedReviewsForCourse();
//
    List<Review> reviews = new ArrayList<>();

    reviews.add(new Review("5", "Great Hands-on Stuff."));
    reviews.add(new Review("5", "Hatsoff."));

    courseRepository.addReviewsForCourse(10003L, reviews );
    //studentRepository.insertHardcodedStudentAndCourse();
    studentRepository.insertStudentAndCourse(new Student("Jack"),
        new Course("Microservices in 100 Steps"));
  }
}
