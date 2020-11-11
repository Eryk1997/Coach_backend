package main.java.coach.TopicController;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = Arrays.asList(new Topic("spring", "Spring Framework", "Description"),
            new Topic("spring 2", "spring framework 2", "DEscritpion"),
            new Topic("spring3", "framework 3 ", "description3"));

    public List<Topic> getAllTopics(){
        return topics;
    }
}
