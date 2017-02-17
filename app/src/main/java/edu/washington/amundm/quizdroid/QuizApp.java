package edu.washington.amundm.quizdroid;

import android.util.Log;

/**
 * Created by Mitchell on 2/15/2017.
 */

public class QuizApp extends android.app.Application {
    private TopicRepository instance = new TopicRepository();

    @Override
    public void onCreate(){
        Log.i("QuizApp", "onCreate");
    }

    public TopicRepository getRepository(){
        return this.instance;
    }


}
