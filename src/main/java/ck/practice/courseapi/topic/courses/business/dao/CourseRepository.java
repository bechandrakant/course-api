package ck.practice.courseapi.topic.courses.business.dao;

import ck.practice.courseapi.topic.courses.business.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findByTopicId(int topicId);
}
