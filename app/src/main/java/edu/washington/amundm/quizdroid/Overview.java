package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class Overview extends AppCompatActivity{

    public static Quiz q;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overviewlayout);

        TextView desc = (TextView)findViewById(R.id.description);
        TextView qCount = (TextView)findViewById(R.id.questioncount);
        Button beginb = (Button)findViewById(R.id.begin);

        Intent intent = getIntent();
        String topic = (String)intent.getExtras().get("Category");
        String description = "This is the " + topic + " quiz";

        q = new Quiz(5, topic, description);

        desc.setText(q.desc);
        qCount.setText("There are " + q.content.size() + " questions in this quiz");
    }

    public void click(View v){
        Intent intent = new Intent(Overview.this, QuestionScreen.class);
        startActivity(intent);
    }
}
