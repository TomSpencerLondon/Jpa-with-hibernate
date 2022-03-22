package com.example.jpawithhibernate.repository;

import com.example.jpawithhibernate.JpaWithHibernateApplication;
import com.example.jpawithhibernate.entity.Passport;
import com.example.jpawithhibernate.entity.Student;
import com.example.jpawithhibernate.repository.StudentRepository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaWithHibernateApplication.class)
class StudentRepositoryTest {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  StudentRepository repository;

  @Autowired
  EntityManager em;

  //Session & Session Factory


  //EntityManager & Persistence Context
  //Transaction

  @Test
  public void someTest() {
    repository.someOperationToUnderstandPersistenceContext();
  }


  @Test
  @Transactional
  public void retrieveStudentAndPassportDetails() {
    Student student = em.find(Student.class, 20001L);
    logger.info("student -> {}", student);
    logger.info("passport -> {}",student.getPassport());
  }


  @Test
  @Transactional
  public void retrievePassportAndAssociatedStudent() {
    Passport passport = em.find(Passport.class, 40001L);
    logger.info("passport -> {}", passport);
    logger.info("student -> {}", passport.getStudent());
  }

  @Test
  @Transactional
  public void retrieveStudentAndCourses() {
    Student student = em.find(Student.class, 20001L);

    logger.info("student -> {}", student);
    logger.info("courses -> {}", student.getCourses());
  }

}

