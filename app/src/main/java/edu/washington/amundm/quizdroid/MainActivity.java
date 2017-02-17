package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] topicStrings;
    private List<Topic> topics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView)findViewById(R.id.topiclist);

        QuizApp app = new QuizApp();
        topics = app.getRepository().getTopics();
        topicStrings = new String[3];

        for(int i=0; i<topics.size();i++){
            String temp = (i + 1) + ". " + topics.get(i).title + "\n" + topics.get(i).desc;
            topicStrings[i] = temp;
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, topicStrings);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = parent.getItemAtPosition(position).toString().trim();
                int index = ((int)itemValue.charAt(0)) - 49;
                System.out.println(index);
                Intent intent = new Intent(MainActivity.this, MainView.class);
                intent.putExtra("Category", index);
                startActivity(intent);
            }
        });
    }


}
