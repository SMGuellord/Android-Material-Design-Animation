package com.example.smgue.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class SharedElement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Inside your activity (if you did not enable transitions in your them)
        * For AppCompat getWindow must be called before calling super.OnCreate().
        * Must be called before setContentView*/

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        initPage();
    }

    public boolean onSupportNavigateUp(){
        finishAfterTransition();
        return true;
    }

    private void initPage(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Shared Element Transition");

        Button btnExit = findViewById(R.id.exit_button);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }
}
