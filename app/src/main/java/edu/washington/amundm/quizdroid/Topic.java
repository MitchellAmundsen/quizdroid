package edu.washington.amundm.quizdroid;

import java.util.ArrayList;

/**
 * Created by Mitchell on 1/30/2017.
 */

public class Topic {

    public String title;
    public String desc;
    public String lDesc;
    public ArrayList<Question> content;
    public int completed;
    public int correct;

    public Topic(int n, String title, String desc){
        this.title = title;
        this.desc = desc;
        this.lDesc = "This Quiz will test you understanding of " + title + " in a fun way!";
        correct = 0;
        completed = 0;
        content = new ArrayList<Question>();
        for(int i=0; i < n; i++){
            Question q = new Question();
            content.add(q);
        }
    }

    public Topic(String title){
        this(5, title, "This is the " + title + " quiz.");
    }

    public void response(String str){
        Question current = content.get(completed);
        completed++;
        current.response(str);
        if(current.isCorrect()){
            correct++;
        }
    }
}
