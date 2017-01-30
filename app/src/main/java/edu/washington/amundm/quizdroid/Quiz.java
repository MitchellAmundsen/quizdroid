package edu.washington.amundm.quizdroid;

import java.util.ArrayList;

/**
 * Created by Mitchell on 1/30/2017.
 */

public class Quiz {

    public String title;
    public String desc;
    public ArrayList<Question> content;
    private int completed;
    public int correct;

    public Quiz(int n, String title, String desc){
        this.title = title;
        this.desc = desc;
        correct = 0;
        completed = 0;
        content = new ArrayList<Question>();
        for(int i=0; i < n; i++){
            Question q = new Question();
            content.add(q);
        }
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
