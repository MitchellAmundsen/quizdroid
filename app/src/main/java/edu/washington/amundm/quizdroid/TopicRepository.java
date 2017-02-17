package edu.washington.amundm.quizdroid;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Mitchell on 2/15/2017.
 */

public class TopicRepository {

    private String[] hardTopics = {"Math", "Science", "Marvel Super Heroes"};
    private List<Topic> topics;

    public TopicRepository(){
        topics = new ArrayList<Topic>();
        for(int i=0; i< hardTopics.length; i++){
            Topic t = new Topic(hardTopics[i]);
            topics.add(t);
        }
    }

    public List<Topic> getTopics(){
        return topics;
    }


}
