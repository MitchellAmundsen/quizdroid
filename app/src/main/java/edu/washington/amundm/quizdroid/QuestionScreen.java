package edu.washington.amundm.quizdroid;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class QuestionScreen extends AppCompatActivity{

    private Button submit;
    private String atext;
    public Question current;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionlayout);

        current = Overview.q.content.get(Overview.q.completed);

        TextView qtext = (TextView)findViewById(R.id.question);
        RadioButton r1 = (RadioButton)findViewById(R.id.r1);
        RadioButton r2 = (RadioButton)findViewById(R.id.r2);
        RadioButton r3 = (RadioButton)findViewById(R.id.r3);
        RadioButton r4 = (RadioButton)findViewById(R.id.r4);

        qtext.setText(current.q);
        r1.setText(current.a1);
        r2.setText(current.a2);
        r3.setText(current.a3);
        r4.setText(current.a4);

        submit = (Button)findViewById(R.id.submit);

        RadioGroup r = (RadioGroup) findViewById(R.id.rg);
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int id){
                RadioButton answer = (RadioButton) group.findViewById(id);
                atext = (String)answer.getText();
                submit.setEnabled(true);
            }

        });
    }

    public void onClick(View v){
        Overview.q.response(atext);
        Intent intent = new Intent(QuestionScreen.this, ResponseScreen.class);
        startActivity(intent);
    }
}
