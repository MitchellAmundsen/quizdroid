package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResponseScreen extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.responselayout);

        TextView answer = (TextView)findViewById(R.id.answer);
        TextView correct = (TextView)findViewById(R.id.correct);
        TextView count = (TextView)findViewById(R.id.count);
        Button next = (Button)findViewById(R.id.next);


    }
}
