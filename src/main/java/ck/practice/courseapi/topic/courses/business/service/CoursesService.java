package ck.practice.courseapi.topic.courses.business.service;

import ck.practice.courseapi.topic.courses.business.dao.CourseRepository;
import ck.practice.courseapi.topic.courses.business.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(int topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(int id) {
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse (int id, Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse (int id) {
        courseRepository.deleteById(id);
    }
}
