package com.puyang.animation;

/**
 * Created by yangpu on 2/22/16.
 */

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.puyang.R;

public class AllAnimation extends Activity {

    private TextView leftRightTvOne;
    private TextView leftRightTvTwo;
    private TextView leftRightTvThree;
    private int screenWidth;

    private AnimatorSet animatorSet;
    private AnimatorSet animatorSet1;
    private ObjectAnimator waveOneAnimator;
    private ObjectAnimator waveTwoAnimator;
    private ObjectAnimator waveThreeAnimator;

    private TextView hangoutTvOne;
    private TextView hangoutTvTwo;
    private TextView hangoutTvThree;
    private TextView windowsTvOne;
    private TextView windowsTvThree;
    private TextView windowsTvTwo;
    private AnimatorSet windowsAnimatorSet;

    private AnimationDrawable myAnimationDrawable1;
    private ImageView fourSquare;
    private ImageView incrementingBoxView;
    private ImageView flowDarkLineImageView, flowLightLineImageView, flowShadowImageView;
    private ImageView flowDarkLineImageView2, flowLightLineImageView2, flowShadowImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_animation);

        //********* hangout ************
        hangoutTvOne = (TextView) findViewById(R.id.hangoutTvOne);
        hangoutTvTwo = (TextView) findViewById(R.id.hangoutTvTwo);
        hangoutTvThree = (TextView) findViewById(R.id.hangoutTvThree);

        hangoutTvOne.setVisibility(View.GONE);
        hangoutTvTwo.setVisibility(View.GONE);
        hangoutTvThree.setVisibility(View.GONE);

        //********* left-right **********
        leftRightTvOne = (TextView) findViewById(R.id.leftRightTvOne);
        leftRightTvTwo = (TextView) findViewById(R.id.leftRightTvTwo);
        leftRightTvThree = (TextView) findViewById(R.id.leftRightTvThree);

        leftRightTvOne.setVisibility(View.GONE);
        leftRightTvTwo.setVisibility(View.GONE);
        leftRightTvThree.setVisibility(View.GONE);

        //********* windows *************
        windowsTvOne = (TextView) findViewById(R.id.windowsTvOne);
        windowsTvTwo = (TextView) findViewById(R.id.windowsTvTwo);
        windowsTvThree = (TextView) findViewById(R.id.windowsTvThree);

        windowsTvOne.setVisibility(View.GONE);
        windowsTvTwo.setVisibility(View.GONE);
        windowsTvThree.setVisibility(View.GONE);

        //********* four square ****************

        fourSquare = (ImageView) findViewById(R.id.fourSquare);
        fourSquare.setVisibility(View.GONE);

        //********* box incrementing ***********

        incrementingBoxView = (ImageView) findViewById(R.id.incrementingBoxView);
        incrementingBoxView.setVisibility(View.GONE);

        //********* Image View Flow ***********

        flowDarkLineImageView = (ImageView) findViewById(R.id.flow_imageview_dark);
        flowDarkLineImageView2 = (ImageView) findViewById(R.id.flow_imageview_dark2);
        flowLightLineImageView = (ImageView) findViewById(R.id.flow_imageview_light);
        flowLightLineImageView2 = (ImageView) findViewById(R.id.flow_imageview_light2);
        flowShadowImageView = (ImageView) findViewById(R.id.flow_imageview_shadow);
        flowShadowImageView2 = (ImageView) findViewById(R.id.flow_imageview_shadow2);
        flowDarkLineImageView.setVisibility(View.GONE);
        flowDarkLineImageView2.setVisibility(View.GONE);
        flowLightLineImageView.setVisibility(View.GONE);
        flowLightLineImageView2.setVisibility(View.GONE);
        flowShadowImageView.setVisibility(View.GONE);
        flowShadowImageView2.setVisibility(View.GONE);

        //--------------------------------------

        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenWidth = displaymetrics.widthPixels;

        if (getIntent().getExtras() != null) {
            String value = getIntent().getStringExtra("value");
            if (value.equalsIgnoreCase("windows")) {

                windowsAnimation();
            } else if (value.equalsIgnoreCase("hangout")) {
                hangoutTvOne.setVisibility(View.VISIBLE);
                hangoutTvTwo.setVisibility(View.VISIBLE);
                hangoutTvThree.setVisibility(View.VISIBLE);

                waveAnimation();
            } else if (value.equalsIgnoreCase("leftright")) {
                leftRightTvOne.setVisibility(View.VISIBLE);
                leftRightTvTwo.setVisibility(View.VISIBLE);
                leftRightTvThree.setVisibility(View.VISIBLE);

                leftToRightToLeftMove();
            } else if (value.equalsIgnoreCase("foursquare")) {
                fourSquare.setVisibility(View.VISIBLE);
                fourSquareAnimation();
            } else if (value.equalsIgnoreCase("incrementingloading")) {
                incrementingBoxView.setVisibility(View.VISIBLE);
                incrementalHorizontalLoading();
            } else if (value.equalsIgnoreCase("imageflow")) {
                flowDarkLineImageView.setVisibility(View.VISIBLE);
                flowDarkLineImageView2.setVisibility(View.VISIBLE);
                flowLightLineImageView.setVisibility(View.VISIBLE);
                flowLightLineImageView2.setVisibility(View.VISIBLE);
                flowShadowImageView.setVisibility(View.VISIBLE);
                flowShadowImageView2.setVisibility(View.VISIBLE);
                flowImageView();
            }
        }
    }

    private static final int TIME_ELAPSE = 10000;
    private static final int TIME_ELAPSE_LIGHT = 15000;

    public void flowImageView() {
        final ValueAnimator valueAnimatorDark = ObjectAnimator.ofFloat(flowDarkLineImageView, "x", -flowDarkLineImageView.getDrawable().getMinimumWidth(), flowDarkLineImageView.getDrawable().getMinimumWidth());
        final ValueAnimator valueAnimatorDark2 = ObjectAnimator.ofFloat(flowDarkLineImageView2, "x", -flowDarkLineImageView2.getDrawable().getMinimumWidth(), flowDarkLineImageView2.getDrawable().getMinimumWidth());
        final ValueAnimator valueAnimatorLight = ObjectAnimator.ofFloat(flowLightLineImageView, "x", -flowLightLineImageView.getDrawable().getMinimumWidth(), flowLightLineImageView.getDrawable().getMinimumWidth());
        final ValueAnimator valueAnimatorLight2 = ObjectAnimator.ofFloat(flowLightLineImageView2, "x", -flowLightLineImageView2.getDrawable().getMinimumWidth(), flowLightLineImageView2.getDrawable().getMinimumWidth());
        final ValueAnimator valueAnimatorShadow = ObjectAnimator.ofFloat(flowShadowImageView, "x", -flowShadowImageView.getDrawable().getMinimumWidth(), flowShadowImageView.getDrawable().getMinimumWidth());
        final ValueAnimator valueAnimatorShadow2 = ObjectAnimator.ofFloat(flowShadowImageView2, "x", -flowShadowImageView2.getDrawable().getMinimumWidth(), flowShadowImageView2.getDrawable().getMinimumWidth());

        valueAnimatorDark.setDuration(TIME_ELAPSE);
        valueAnimatorDark.setRepeatCount(-1);
        valueAnimatorDark.setRepeatMode(ValueAnimator.INFINITE);
        valueAnimatorDark.setInterpolator(new LinearInterpolator());
        valueAnimatorDark.start();

        valueAnimatorDark2.setDuration(TIME_ELAPSE);
        valueAnimatorDark2.setRepeatCount(-1);
        valueAnimatorDark2.setRepeatMode(ValueAnimator.INFINITE);
        valueAnimatorDark2.setInterpolator(new LinearInterpolator());
        valueAnimatorDark2.setStartDelay(TIME_ELAPSE / 2);
        valueAnimatorDark2.start();

        valueAnimatorLight.setDuration(TIME_ELAPSE_LIGHT);
        valueAnimatorLight.setRepeatCount(-1);
        valueAnimatorLight.setRepeatMode(ValueAnimator.INFINITE);
        valueAnimatorLight.setInterpolator(new LinearInterpolator());
        valueAnimatorLight.start();

        valueAnimatorLight2.setDuration(TIME_ELAPSE_LIGHT);
        valueAnimatorLight2.setRepeatCount(-1);
        valueAnimatorLight2.setRepeatMode(ValueAnimator.INFINITE);
        valueAnimatorLight2.setInterpolator(new LinearInterpolator());
        valueAnimatorLight2.setStartDelay(TIME_ELAPSE_LIGHT / 2);
        valueAnimatorLight2.start();

        valueAnimatorShadow.setDuration(TIME_ELAPSE);
        valueAnimatorShadow.setRepeatCount(-1);
        valueAnimatorShadow.setRepeatMode(ValueAnimator.INFINITE);
        valueAnimatorShadow.setInterpolator(new LinearInterpolator());
        valueAnimatorShadow.start();

        valueAnimatorShadow2.setDuration(TIME_ELAPSE);
        valueAnimatorShadow2.setRepeatCount(-1);
        valueAnimatorShadow2.setRepeatMode(ValueAnimator.INFINITE);
        valueAnimatorShadow2.setInterpolator(new LinearInterpolator());
        valueAnimatorShadow2.setStartDelay(TIME_ELAPSE / 2);
        valueAnimatorShadow2.start();

        /*animatorSet1 = new AnimatorSet();
        animatorSet1.playTogether(valueAnimatorDark, valueAnimatorDark2);
        animatorSet1.start();*/
    }

    public void waveAnimation() {
        PropertyValuesHolder tvOne_Y = PropertyValuesHolder.ofFloat(hangoutTvOne.TRANSLATION_Y, -40.0f);
        PropertyValuesHolder tvOne_X = PropertyValuesHolder.ofFloat(hangoutTvOne.TRANSLATION_X, 0f);
        waveOneAnimator = ObjectAnimator.ofPropertyValuesHolder(hangoutTvOne, tvOne_X, tvOne_Y);
        waveOneAnimator.setRepeatCount(-1);
        waveOneAnimator.setRepeatMode(ValueAnimator.REVERSE);
        waveOneAnimator.setDuration(300);
        waveOneAnimator.start();

        PropertyValuesHolder tvTwo_Y = PropertyValuesHolder.ofFloat(hangoutTvTwo.TRANSLATION_Y, -40.0f);
        PropertyValuesHolder tvTwo_X = PropertyValuesHolder.ofFloat(hangoutTvTwo.TRANSLATION_X, 0f);
        waveTwoAnimator = ObjectAnimator.ofPropertyValuesHolder(hangoutTvTwo, tvTwo_X, tvTwo_Y);
        waveTwoAnimator.setRepeatCount(-1);
        waveTwoAnimator.setRepeatMode(ValueAnimator.REVERSE);
        waveTwoAnimator.setDuration(300);
        waveTwoAnimator.setStartDelay(100);
        waveTwoAnimator.start();

        PropertyValuesHolder tvThree_Y = PropertyValuesHolder.ofFloat(hangoutTvThree.TRANSLATION_Y, -40.0f);
        PropertyValuesHolder tvThree_X = PropertyValuesHolder.ofFloat(hangoutTvThree.TRANSLATION_X, 0f);
        waveThreeAnimator = ObjectAnimator.ofPropertyValuesHolder(hangoutTvThree, tvThree_X, tvThree_Y);
        waveThreeAnimator.setRepeatCount(-1);
        waveThreeAnimator.setRepeatMode(ValueAnimator.REVERSE);
        waveThreeAnimator.setDuration(300);
        waveThreeAnimator.setStartDelay(200);
        waveThreeAnimator.start();
    }

    public void leftToRightToLeftMove() {

        final ValueAnimator valueTvOne_x = ObjectAnimator.ofFloat(leftRightTvOne, "x", leftRightTvOne.getX(), screenWidth * .9f);

        valueTvOne_x.setDuration(1000);
        valueTvOne_x.setRepeatCount(0);
        valueTvOne_x.setRepeatMode(ValueAnimator.REVERSE);
        valueTvOne_x.setInterpolator(new DecelerateInterpolator());

        final ValueAnimator valueTvTwo_x = ObjectAnimator.ofFloat(leftRightTvTwo, "x", leftRightTvTwo.getX(), screenWidth * .93f);//- 35);

        valueTvTwo_x.setDuration(1000);
        valueTvTwo_x.setRepeatCount(0);
        valueTvTwo_x.setRepeatMode(ValueAnimator.REVERSE);
        valueTvTwo_x.setInterpolator(new DecelerateInterpolator());

        final ValueAnimator valueTvThree_x = ObjectAnimator.ofFloat(leftRightTvThree, "x", leftRightTvThree.getX(), screenWidth * .96f);// - 20);

        valueTvThree_x.setDuration(1000);
        valueTvThree_x.setRepeatCount(0);
        valueTvThree_x.setRepeatMode(ValueAnimator.REVERSE);
        valueTvThree_x.setInterpolator(new DecelerateInterpolator());

        animatorSet1 = new AnimatorSet();
        animatorSet1.playSequentially(valueTvOne_x, valueTvTwo_x, valueTvThree_x);

        animatorSet1.start();
        animatorSet1.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ValueAnimator valueTvOne_x = ObjectAnimator.ofFloat(leftRightTvOne, "x", leftRightTvOne.getX(), leftRightTvOne.getX() * .01f);

                valueTvOne_x.setDuration(1000);
                valueTvOne_x.setRepeatCount(0);
                valueTvOne_x.setRepeatMode(ValueAnimator.REVERSE);
                valueTvOne_x.setInterpolator(new DecelerateInterpolator());

                final ValueAnimator valueTvTwo_x = ObjectAnimator.ofFloat(leftRightTvTwo, "x", leftRightTvTwo.getX(), leftRightTvTwo.getX() * .03f);

                valueTvTwo_x.setDuration(1000);
                valueTvTwo_x.setRepeatCount(0);
                valueTvTwo_x.setRepeatMode(ValueAnimator.REVERSE);
                valueTvTwo_x.setInterpolator(new DecelerateInterpolator());

                final ValueAnimator valueTvThree_x = ObjectAnimator.ofFloat(leftRightTvThree, "x", leftRightTvThree.getX(), leftRightTvThree.getX() * .06f);

                valueTvThree_x.setDuration(1000);
                valueTvThree_x.setRepeatCount(0);
                valueTvThree_x.setRepeatMode(ValueAnimator.REVERSE);
                valueTvThree_x.setInterpolator(new DecelerateInterpolator());

                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(valueTvThree_x, valueTvTwo_x, valueTvOne_x);

                animatorSet.start();
                animatorSet.addListener(new AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animatorSet1.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }
                });
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        });

    }

    public void windowsAnimation() {

        final ValueAnimator valueTvOne_x = ObjectAnimator.ofFloat(windowsTvOne, "x", windowsTvOne.getX() - 40, windowsTvOne.getX() - 50, (screenWidth / 2) + 10f, (screenWidth / 2) + 25f,
                (screenWidth / 2) + 50f//,(screenWidth / 2)+55f//,(screenWidth / 2)+80f//,(screenWidth/2 )+25f,(screenWidth / 2) +30f//, (screenWidth / 2)+35f,(screenWidth / 2)+40f,(screenWidth / 2)+45f //,(screenWidth / 2)+6.6f,(screenWidth / 2)+7.7f,(screenWidth / 2)+8.8f //, (screenWidth / 2)+9,(screenWidth / 2)+10,
                , screenWidth * .92f, screenWidth + 5);

        valueTvOne_x.setDuration(5200);
        valueTvOne_x.setRepeatCount(0);
        valueTvOne_x.setRepeatMode(ValueAnimator.REVERSE);

        valueTvOne_x.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvOne.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

        final ValueAnimator valueTvTwo_x = ObjectAnimator.ofFloat(windowsTvTwo, "x", windowsTvTwo.getX() - 50, (screenWidth / 2.1f) + 10f, (screenWidth / 2.1f) + 25f, (screenWidth / 2.1f) + 50f//, (screenWidth / 2.1f) +55f//, (screenWidth / 2.1f) +80f//, (screenWidth / 2.1f) +25f,(screenWidth / 2.1f) +30f
                , screenWidth * .94f, screenWidth + 5);

        valueTvTwo_x.setDuration(6000);
        valueTvTwo_x.setRepeatCount(0);
        valueTvTwo_x.setStartDelay(200);
        valueTvTwo_x.setRepeatMode(ValueAnimator.REVERSE);

        valueTvTwo_x.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvTwo.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

        final ValueAnimator valueTvThree_x = ObjectAnimator.ofFloat(windowsTvThree, "x", windowsTvThree.getX() - 50, (screenWidth / 2.2f) + 10f, (screenWidth / 2.2f) + 25f, (screenWidth / 2.2f) + 50f//,(screenWidth / 2.2f) +55f//,(screenWidth / 2.2f) +80f//,(screenWidth / 2.2f) +25f,(screenWidth / 2.2f) +30f
                , screenWidth * .94f, screenWidth + 5);

        valueTvThree_x.setDuration(6500);
        valueTvThree_x.setRepeatCount(0);
        valueTvTwo_x.setStartDelay(500);
        valueTvThree_x.setRepeatMode(ValueAnimator.REVERSE);

        valueTvThree_x.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {
                windowsTvThree.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

        windowsAnimatorSet = new AnimatorSet();
        windowsAnimatorSet.playTogether(valueTvTwo_x, valueTvThree_x, valueTvOne_x);

        windowsAnimatorSet.start();
        windowsAnimatorSet.addListener(new AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                windowsAnimatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }
        });

    }

    public void fourSquareAnimation() {
        myAnimationDrawable1 = (AnimationDrawable) fourSquare.getDrawable();

        myAnimationDrawable1.start();
    }

    public void incrementalHorizontalLoading() {
        myAnimationDrawable1 = (AnimationDrawable) incrementingBoxView.getDrawable();

        myAnimationDrawable1.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (animatorSet1 != null) {
            animatorSet1.cancel();
            animatorSet1.removeAllListeners();
        }

        if (windowsAnimatorSet != null) {
            windowsAnimatorSet.cancel();
            windowsAnimatorSet.removeAllListeners();
        }

        if (waveOneAnimator != null && waveTwoAnimator != null && waveThreeAnimator != null) {
            waveOneAnimator.cancel();
            waveOneAnimator.removeAllListeners();

            waveTwoAnimator.cancel();
            waveTwoAnimator.removeAllListeners();

            waveThreeAnimator.cancel();
            waveThreeAnimator.removeAllListeners();
        }

        if (myAnimationDrawable1 != null) {
            myAnimationDrawable1.stop();
        }

    }

    @Override
    public void onBackPressed() {
        onDestroy();
        super.onBackPressed();
    }

}
