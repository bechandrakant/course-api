package ck.practice.courseapi.topic.courses.lessons.business.service;

import ck.practice.courseapi.topic.courses.lessons.business.dao.LessonRepository;
import ck.practice.courseapi.topic.courses.lessons.business.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LessonsService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(int topicId, int courseId) {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findLessonByCourseId(courseId)
                .forEach(lessons::add);
        return lessons;
    }

    public Optional<Lesson> getLesson(int topicsId, int courseId, int lessonId) {
        return lessonRepository.findById(lessonId);
    }

    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(int lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
