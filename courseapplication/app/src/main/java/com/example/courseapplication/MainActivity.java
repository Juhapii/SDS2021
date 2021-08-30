package com.example.courseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button itemListBtn = (Button) findViewById(R.id.itemListBtn);
        itemListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), itemListActivity.class);
                //pass information to second activity TEST PURPOSE
                startIntent.putExtra("org.example.courseapplication.SOMETHING", "Hello WORLD TEST");
                startActivity(startIntent);
            }
        });

    }
}