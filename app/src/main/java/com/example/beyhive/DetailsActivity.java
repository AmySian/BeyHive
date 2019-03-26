package com.example.beyhive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView name = findViewById(R.id.artistName);
        TextView description = findViewById(R.id.trackName);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        description.setText((intent.getStringExtra("description")));
    }


}

