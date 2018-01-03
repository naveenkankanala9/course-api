package com.springboot.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("java", "core java", "core java description"),
			new Topic("javascript", "javaScript", "javaScript description"),
			new Topic("spring", "Srping Framework", "Spring Framework description")
			));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
