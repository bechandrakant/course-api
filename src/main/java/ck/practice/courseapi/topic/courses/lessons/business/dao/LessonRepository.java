package ck.practice.courseapi.topic.courses.lessons.business.dao;

import ck.practice.courseapi.topic.courses.lessons.business.model.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {

    List<Lesson> findLessonByCourseId (int courseId);
}
