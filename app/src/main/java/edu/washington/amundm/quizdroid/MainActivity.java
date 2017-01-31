package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView)findViewById(R.id.topiclist);

        String[] topics = new String[] {"Math", "Science", "Marvel Super Heroes"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, topics);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = parent.getItemAtPosition(position).toString().trim();

                Intent intent = new Intent(MainActivity.this, Overview.class);
                intent.putExtra("Category", itemValue);
                startActivity(intent);
            }
        });
    }


}
