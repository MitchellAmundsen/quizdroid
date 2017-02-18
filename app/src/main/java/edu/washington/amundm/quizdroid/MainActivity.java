package edu.washington.amundm.quizdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import java.util.List;
import java.net.URL;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    private String[] topicStrings;
    private List<Topic> topics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView)findViewById(R.id.topiclist);

        //String jstring = getJSON("http://tednewardsandbox.site44.com/questions.json");
        //outputJSON(jstring);

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

    /*
    private String getJSON(String site){
        try {
            URL request = new URL(site);
             InputStream is = request.openStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[1024];
            int read;
            while((read = br.read(chars)) != -1){
                buffer.append(chars, 0, read);
            }
            br.close();
            return buffer.toString();
        }catch (java.net.MalformedURLException e) {
            System.out.println("exception caught: " + e);
        } catch (IOException e) {
            System.out.println(e);
        }
        // will never hit
        return null;
    }

    private void outputJSON(String j){
        try {
            PrintWriter writer = new PrintWriter("topic_store.txt");
            writer.println(j);
            writer.close();
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    */

}
