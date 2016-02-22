package com.puyang.justforfun;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;

import com.facebook.rebound.ui.SpringConfiguratorView;

/**
 * Created by yangpu on 1/12/16.
 */
public class OrigamiAnimationActivity extends Activity {

    private OrigamiAnimationView mOrigamiAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.origami_animation_layout);

        mOrigamiAnimationView = (OrigamiAnimationView) findViewById(R.id.origami_animation_view);

        mOrigamiAnimationView.popAnimation(true);
        mOrigamiAnimationView.transition(1, 1, 100);
    }
}
