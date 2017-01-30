package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuestionScreen extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout);

        TextView question = (TextView)findViewById(R.id.question);
        Button a1 = (Button)findViewById(R.id.a1);
        Button a2 = (Button)findViewById(R.id.a2);
        Button a3 = (Button)findViewById(R.id.a3);
        Button a4 = (Button)findViewById(R.id.a4);


    }
}
