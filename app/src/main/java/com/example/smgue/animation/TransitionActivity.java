package com.example.smgue.animation;

import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {

    Constant.TransitionType type;
    String toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

//        getWindow().setAllowEnterTransitionOverlap(false);
        initPage();

        initAnimation();

    }

    private void initPage(){
        type = (Constant.TransitionType) getIntent().getSerializableExtra(Constant.KEY_ANIM_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constant.KEY_TITLE);

        Button btnExit = findViewById(R.id.exit_button);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finishAfterTransition();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);
    }
    public boolean onSupportNavigateUp(){
        finishAfterTransition();
        return true;
    }

    private void initAnimation(){

        switch(type){
            case ExplodeJava:{
                Explode enterTransition = new Explode();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case ExplodeXML:{

                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case FadeJava:{

                Fade enterTransition = new Fade();
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                enterTransition.setInterpolator(new FastOutLinearInInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case FadeXML:{
                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                getWindow().setEnterTransition(enterTransition);
                break;
            }

            case SlideJava:{
                Slide enterTransition = new Slide();
                enterTransition.setSlideEdge(Gravity.BOTTOM);
                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                enterTransition.setInterpolator(new FastOutLinearInInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
            }
            case SlideXML:{
                Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                getWindow().setEnterTransition(enterTransition);
                break;
            }
        }
    }
}
