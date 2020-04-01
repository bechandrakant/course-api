package ck.practice.courseapi.topic.courses.business.controller;

import ck.practice.courseapi.topic.courses.business.model.Course;
import ck.practice.courseapi.topic.courses.business.service.CoursesService;
import ck.practice.courseapi.topic.business.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping("topics/{topicsId}/courses")
    public List<Course> getAllCourses (@PathVariable int topicsId) {
        return coursesService.getAllCourses (topicsId);
    }

    @GetMapping("topics/{topicId}/courses/{courseId}")
    public Optional<Course> getCourse (@PathVariable int topicId, @PathVariable int courseId) {
        return coursesService.getCourse (courseId);
    }

    @PostMapping("topics/{topicId}/courses")
    public void addCourse (@RequestBody Course course, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        coursesService.addCourse (course);
    }

    @PutMapping("topics/{topicId}/courses/{id}")
    public void updateCourse (@RequestBody Course course, @PathVariable int topicId, @PathVariable int courseId) {
        coursesService.updateCourse(courseId, course);
    }

    @DeleteMapping("topics/{topicId}/courses/{id}")
    public void deleteCourse (@PathVariable int topicId, @PathVariable int courseId) {
        coursesService.deleteCourse(courseId);
    }
}
