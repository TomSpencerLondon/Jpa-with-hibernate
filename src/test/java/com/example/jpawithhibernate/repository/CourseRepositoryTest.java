package com.example.jpawithhibernate.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.jpawithhibernate.JpaWithHibernateApplication;
import com.example.jpawithhibernate.entity.Course;
import com.example.jpawithhibernate.entity.Review;
import com.example.jpawithhibernate.repository.CourseRepository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaWithHibernateApplication.class)
class CourseRepositoryTest {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  CourseRepository repository;

  @Autowired
  EntityManager em;

  @Test
  @DirtiesContext
  public void findById_basic() {
    Course course = repository.findById(10001L);
    assertEquals("JPA in 50 Steps", course.getName());
  }

  @Test
  @DirtiesContext
  public void deleteById_basic() {
    repository.deleteById(10002L);
    assertNull(repository.findById(10002L));
  }

  @Test
  @DirtiesContext
  public void save_basic() {

    // get a course
    Course course = repository.findById(10001L);
    assertEquals("JPA in 50 Steps", course.getName());

    // update details
    course.setName("JPA in 50 Steps - Updated");
    repository.save(course);

    // check the value
    Course course1 = repository.findById(10001L);
    assertEquals("JPA in 50 Steps - Updated", course1.getName());
  }

  @Test
  @DirtiesContext
  public void playWithEntityManager() {
    repository.playWithEntityManager();
  }

  @Test
  @Transactional
  public void retrieveReviewsForCourse() {
    Course course = repository.findById(10001L);
    logger.info("{}",course.getReviews());
  }

  @Test
  @Transactional
  public void retrieveCourseForReview() {
    Review review = em.find(Review.class, 50001L);
    logger.info("{}",review.getCourse());
  }

}