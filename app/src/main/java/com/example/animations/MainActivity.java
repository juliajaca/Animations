package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void animacion(View v){
        ImageView im = (ImageView) findViewById(R.id.imagen_circulo);
        im.setImageResource(R.drawable.circulo);

        // First parameter is the view to be animated. Second parameter is the name of property
        ObjectAnimator.ofFloat(im, "translationX", 0F, 1000F).setDuration(1000).start();
        ObjectAnimator.ofFloat(im, "translationY", 0f, 1000f).setDuration(1000).start();

        ObjectAnimator.ofFloat(im, "X", 0f, 1000f).setDuration(1000).start();
        ObjectAnimator.ofFloat(im, "Y", 0f, 1000f).setDuration(1000).start();

        ObjectAnimator.ofFloat(im, "rotation", 0f, 360f).setDuration(1000).start();

    }

    public void animacion2(View v){
        View cielo =  (View) findViewById(R.id.cielo);
        ImageView sol = (ImageView) findViewById(R.id.imagen_circulo);

        AnimatorSet set1 = new AnimatorSet();
        Animator animator2 = ObjectAnimator.ofFloat(sol, "translationY", 0f,450f);
        animator2.setDuration(3000);
        Animator animator3 = ObjectAnimator.ofObject(cielo, "backgroundColor", new ArgbEvaluator(),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3));
        animator3.setDuration(3000);
        Animator animator4 = ObjectAnimator.ofObject(cielo, "backgroundColor", new ArgbEvaluator(),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4));

        set1.playTogether(animator2,animator3);
        set1.start();


        animator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(MainActivity.this, "end", Toast.LENGTH_SHORT).show();
                animator4.setStartDelay(1500);
                animator4.start();
            }
            // Override other functions if we need
        });

    }







    }