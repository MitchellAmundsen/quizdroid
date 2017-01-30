package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;


public class Overview extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overviewlayout);

        TextView desc = (TextView)findViewById(R.id.description);
        TextView qCount = (TextView)findViewById(R.id.questioncount);
        Button beginb = (Button)findViewById(R.id.begin);


    }
}
