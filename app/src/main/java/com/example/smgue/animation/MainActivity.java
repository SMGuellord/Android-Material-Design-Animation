package com.example.smgue.animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLogo, imgProfilePic;
    private TextView txvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogo = findViewById(R.id.imgSmartherdLogo);
        imgProfilePic = findViewById(R.id.imgProfile);
        txvShared = findViewById(R.id.txvSharedElement);

        setupWindowAnimations();
    }

    //Transition for the main activity
    private void setupWindowAnimations(){
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
//        getWindow().setAllowReturnTransitionOverlap(false);
    }

    public void checkRippleAnimation(View view){

        Intent intent = new Intent(this, RippleActivity.class);
        startActivity(intent);
    }

    public void sharedElementTransition(View view){
        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View, String>(imgLogo, "logo_shared");
        pair[1] = new Pair<View, String>(txvShared, "smartherd_shared");
        pair[2] = new Pair<View, String>(imgProfilePic, "profile_pic_shared");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent intent = new Intent(MainActivity.this, SharedElement.class);
        startActivity(intent, options.toBundle());
    }

    public void explodeTransitionByCode(View view){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constant.KEY_ANIM_TYPE, Constant.TransitionType.ExplodeJava);
        i.putExtra(Constant.KEY_TITLE, "Explode by Java");
        startActivity(i, options.toBundle());
    }

    public void explodeTransitionByXML(View view){

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constant.KEY_ANIM_TYPE, Constant.TransitionType.ExplodeXML);
        i.putExtra(Constant.KEY_TITLE, "Explode by XML");
        startActivity(i, options.toBundle());
    }

    public void slideTransitionByCode(View view){

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constant.KEY_ANIM_TYPE, Constant.TransitionType.SlideJava);
        i.putExtra(Constant.KEY_TITLE, "Slide by Java");
        startActivity(i, options.toBundle());
    }

    public void slideTransitionByXML(View view){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constant.KEY_ANIM_TYPE, Constant.TransitionType.SlideXML);
        i.putExtra(Constant.KEY_TITLE, "Slide by XML");
        startActivity(i, options.toBundle());

    }

    public void fadeTransitionByCode(View view){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constant.KEY_ANIM_TYPE, Constant.TransitionType.FadeJava);
        i.putExtra(Constant.KEY_TITLE, "Fade Java");
        startActivity(i, options.toBundle());

    }

    public void fadeTransitionByXML(View view){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constant.KEY_ANIM_TYPE, Constant.TransitionType.FadeXML);
        i.putExtra(Constant.KEY_TITLE, "Fade by XML");
        startActivity(i, options.toBundle());

    }
}
