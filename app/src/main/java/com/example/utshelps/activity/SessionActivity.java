package com.example.utshelps.activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.utshelps.R;

/**Activity that shows sessions list of a workshop
 * Created by Ferdy on 10/3/2016.
 */

public class SessionActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] mSession_names;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        mListView = (ListView)findViewById(R.id.list_view); //Create reference to listView in activity_session
        mSession_names = getResources().getStringArray(R.array.session_names); //Grabs the string arrays in string.xml
        int i = 0;
        for(String titles: mSession_names){
            SessionsData sessionData = new SessionsData(titles, mSession_names[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.session_view, menu);
        return true;
    }





}

