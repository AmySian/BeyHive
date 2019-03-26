package com.example.beyhive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;


public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private MyController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);

        controller = new MyController(this);
        controller.onStart();

        //mMessageEditText = (EditText) findViewById(R.id.editText_main);

        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
    }

    public void showList(final List<MonApi> input){
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new ClickMe(getApplicationContext(), recyclerView, new ClickMe.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                MonApi api= input.get(position);
                //Toast.makeText(getApplicationContext(), ((Api) api).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("description",api.getTrackName());
                intent.putExtra("name",api.getArtistName());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private static final String LOG_TAG = MainActivity.class.getSimpleName();



    //private EditText mMessageEditText;

    public void launchDetailsActivity(View view) {
        //Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, DetailsActivity.class);
        //String message = mMessageEditText.getText().toString();

        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}