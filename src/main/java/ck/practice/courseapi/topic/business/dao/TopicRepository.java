package ck.practice.courseapi.topic.business.dao;

import ck.practice.courseapi.topic.business.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
