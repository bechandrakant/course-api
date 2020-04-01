package ck.practice.courseapi.topic.business.controller;

import ck.practice.courseapi.topic.business.service.TopicsService;
import ck.practice.courseapi.topic.business.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicsController {

    @Autowired
    private TopicsService topicsService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics () {
        return topicsService.getAllTopics();
    }

    @GetMapping(value = "/topics/{id}")
    public Optional<Topic> getTopic (@PathVariable int id) {
        return topicsService.getTopic (id);
    }

    @PostMapping("/topics")
    public void addTopic (@RequestBody Topic topic) {
        topicsService.addTopic (topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic (@RequestBody Topic topic, @PathVariable int id) {
        topicsService.updateTopic (id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic (@PathVariable int id) {
        topicsService.deleteTopic (id);
    }
}
