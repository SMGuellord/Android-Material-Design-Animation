package com.example.smgue.animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
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
}
