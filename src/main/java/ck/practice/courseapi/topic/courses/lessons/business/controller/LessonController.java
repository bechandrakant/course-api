package ck.practice.courseapi.topic.courses.lessons.business.controller;

import ck.practice.courseapi.topic.courses.business.model.Course;
import ck.practice.courseapi.topic.courses.lessons.business.model.Lesson;
import ck.practice.courseapi.topic.courses.lessons.business.service.LessonsService;
import ck.practice.courseapi.topic.business.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {

    @Autowired
    private LessonsService lessonsService;

    @GetMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons (@PathVariable int topicId, @PathVariable int courseId) {
        return lessonsService.getAllLessons (topicId, courseId);
    }

    @GetMapping("/topics/{topicsId}/courses/{coursesId}/lessons/{lessonId}")
    public Optional<Lesson> getLesson (@PathVariable int topicsId,
                                      @PathVariable int courseId,
                                      @PathVariable int lessonId) {
        return lessonsService.getLesson (topicsId, courseId, lessonId);
    }

    @PostMapping("/topics/{topicsId}/courses/{courseId}/lessons")
    public void addLesson (@PathVariable int topicsId,
                           @PathVariable int courseId,
                           @RequestBody Lesson lesson) {
        Course course = new Course(courseId, "", "", topicsId);
        course.setTopic(new Topic(topicsId, "", ""));
        lesson.setCourse(course);
        lessonsService.addLesson (lesson);
    }

    @PutMapping("/topics/{topicsId}/courses/{courseId}/lessons/{lessonId}")
    public void updateLesson (@PathVariable int topicsId,
                              @PathVariable int courseId,
                              @PathVariable int lessonId,
                              @RequestBody Lesson lesson) {
        Course course = new Course(courseId, "", "", topicsId);
        course.setTopic(new Topic(topicsId, "", ""));
        lesson.setCourse(course);
        lessonsService.updateLesson (lesson);
    }

    @DeleteMapping("/topics/{topicsId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson (@PathVariable int topicsId,
                              @PathVariable int courseId,
                              @PathVariable int lessonId) {
        lessonsService.deleteLesson (lessonId);
    }
}
