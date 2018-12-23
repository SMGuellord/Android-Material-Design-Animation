package com.example.smgue.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SharedElement extends AppCompatActivity {

    private RelativeLayout mReavelDemo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Inside your activity (if you did not enable transitions in your them)
        * For AppCompat getWindow must be called before calling super.OnCreate().
        * Must be called before setContentView*/

//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
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

        mReavelDemo = findViewById(R.id.click_reveal);
        mReavelDemo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                makeCircularRevealAnimation(mReavelDemo);
            }
        });

        Button btnExit = findViewById(R.id.exit_button);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAfterTransition();
            }
        });
    }

    private void makeCircularRevealAnimation(View view){
        final TextView textDesc = findViewById(R.id.textDesc);

        int centerX = (view.getLeft() + view.getRight())/2;
        int centerY = (view.getTop() + view.getBottom())/2;

        float radius = Math.max(textDesc.getWidth(), textDesc.getHeight()) * 2.0f;

        if(textDesc.getVisibility() == View.INVISIBLE){
            textDesc.setVisibility(View.VISIBLE);
            textDesc.setText(R.string.description);

            ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, 0, radius).start();
        }else{
            Animator reveal = ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, radius, 0);
            reveal.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                   textDesc.setVisibility(View.INVISIBLE);
                }
            });
            reveal.start();
        }
    }
}
