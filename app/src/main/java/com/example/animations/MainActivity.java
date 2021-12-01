package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
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

    private AnimationDrawable mAnimationDrawable;

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

    public void animacion2(){
        //ImageView im = (ImageView) findViewById(R.id.imagen_circulo);
        //im.setImageResource(R.drawable.circulo);
        View view = this.getWindow().getDecorView();
        ImageView texto = (ImageView) findViewById(R.id.imagen_circulo);
        texto.setImageResource(R.drawable.circulo);

        AnimatorSet set1 = new AnimatorSet();
        //Animator animator1 = ObjectAnimator.ofFloat(texto, "translationX", 0F, 200F);
        Animator animator2 = ObjectAnimator.ofFloat(texto, "translationY", -300f,300f);
        animator2.setDuration(5000);
        Animator animator3 = ObjectAnimator.ofObject(view, "backgroundColor", new ArgbEvaluator(),  Color.BLUE,  Color.BLACK, Color.YELLOW);
        animator3.setDuration(5000);
        //Animator animator4 = ObjectAnimator.ofFloat(texto, "translationY", -300f,300f);

        set1.playTogether(animator2,animator3);
        set1.start();
        //Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
         //texto.startAnimation(animacion);

        //mAnimationDrawable.start();

        // First parameter is the view to be animated. Second parameter is the name of property
        //ObjectAnimator.ofFloat(im, "translationX", 0F, 1000F).setDuration(1000).start();
        //ObjectAnimator.ofFloat(im, "translationY", 0f, 1000f).setDuration(1000).start();

        //ObjectAnimator.ofFloat(im, "X", 0f, 1000f).setDuration(1000).start();
        //ObjectAnimator.ofFloat(im, "Y", 0f, 1000f).setDuration(1000).start();

        //ObjectAnimator.ofFloat(im, "rotation", 0f, 360f).setDuration(1000).start();

    }




    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Log.d("Consola", "clicado");
            animacion2();
        }
         return super.onTouchEvent(event);
    }


    }