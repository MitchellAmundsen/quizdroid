package edu.washington.amundm.quizdroid;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.app.FragmentManager;

public class MainView extends AppCompatActivity {
    Quiz q;
    Button next;
    boolean isQuestion;
    boolean isFinished;
    FragmentManager fm;
    QuestionScreenFragment currentQS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);

        next = (Button)findViewById(R.id.next);
        isQuestion = false;
        isFinished = false;

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!isQuestion && !isFinished){
                    isQuestion = true;
                    FragmentTransaction currentran = fm.beginTransaction();
                    Question now = q.content.get(q.completed);
                    currentQS = QuestionScreenFragment.newInstance(now.a1,
                            now.a2, now.a3, now.a4, now.q);
                    currentran.replace(R.id.placeholder, currentQS);
                    currentran.commit();
                    next.setText("Next");
                } else if(isQuestion){
                    isQuestion = false;
                    FragmentTransaction currenttran = fm.beginTransaction();
                    q.response(currentQS.getAnswer());
                    String correctcount = "You have scored " + q.correct + " out of " +
                            q.completed + " correct.";
                    Question now = q.content.get(q.completed - 1);
                    ResponseScreenFragment rs = ResponseScreenFragment.newInstance(
                            now.response, now.correct, correctcount);
                    currenttran.replace(R.id.placeholder, rs);
                    currenttran.commit();
                    if(q.content.size() == q.completed){
                        next.setText("Finish");
                        isFinished = true;
                    }
                }else{
                    isFinished = false;
                    Intent intent = new Intent(MainView.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        Intent intent = getIntent();
        String topic = (String)intent.getExtras().get("Category");
        String description = "This is the " + topic + " quiz";
        q = new Quiz(5, topic, description);
        String qCount = "There are " + q.content.size() + " questions in this quiz.";

        OverviewFragment o = OverviewFragment.newInstance(description, qCount);
        fm = getFragmentManager();
        FragmentTransaction tx = fm.beginTransaction();
        tx.replace(R.id.placeholder, o);
        tx.commit();
        isQuestion = false;
    }
}
