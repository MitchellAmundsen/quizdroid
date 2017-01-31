package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class ResponseScreen extends AppCompatActivity{

    public Question current;
    public Button next;
    private boolean last;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.responselayout);

        last = false;
        current = Overview.q.content.get(Overview.q.completed - 1);

        TextView answer = (TextView)findViewById(R.id.answer);
        TextView correct = (TextView)findViewById(R.id.correct);
        TextView count = (TextView)findViewById(R.id.count);
        next = (Button)findViewById(R.id.next);

        String correctcount = "You have scored " + Overview.q.correct + " out of " +
                Overview.q.completed + " correct.";

        answer.setText(current.response);
        correct.setText(current.correct);
        count.setText(correctcount);

        if(Overview.q.content.size() == Overview.q.completed){
            last = true;
            next.setText("Finish");
        }
    }

    public void onClick(View v){
        Intent intent;
        if(last){
            intent = new Intent(ResponseScreen.this, MainActivity.class);
        }else{
            intent = new Intent(ResponseScreen.this, QuestionScreen.class);
        }
        startActivity(intent);

    }
}
