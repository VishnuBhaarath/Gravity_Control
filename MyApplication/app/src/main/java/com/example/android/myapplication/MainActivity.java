package com.example.android.myapplication;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView move;
private LinearLayout body;
private int a=1000;
private int j;
private int k;
private int m;
boolean Click = true;
boolean gravitydown=true;

    ObjectAnimator objectanimator1;
    ObjectAnimator objectanimator2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] stoneImages = {
                R.drawable.bluestone,
                R.drawable.green,
                R.drawable.yellow,
                R.drawable.pink,
                R.drawable.redstone
        };
        j = new Random().nextInt(4);
        k=new Random().nextInt(1000);
        m=new Random().nextInt(1500);
        body=(LinearLayout)findViewById(R.id.body);
        final Drawable drawable = getDrawable(stoneImages[j]);
        move=(ImageView) findViewById(R.id.move);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
               LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(k,m , 0, 0);
        params.height=params.width=100;
        move.setLayoutParams(params);
        move.setBackground(drawable);
        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(Click){
                   gravitydown = !gravitydown;
                   if(gravitydown){
                   Drawable drawable1=getDrawable(R.drawable.gravitydown);
                   body.setBackground(drawable1);
                   objectanimator1 = ObjectAnimator.ofFloat(move,"y",1580);
                   objectanimator1.setDuration(7000);
                   objectanimator1.start();
               }
                else {
                   Drawable drawable2=getDrawable(R.drawable.gravityup);
                   body.setBackground(drawable2);
                   objectanimator2=ObjectAnimator.ofFloat(move,"y",0);
                   objectanimator2.setDuration(7000);
                   objectanimator2.start();
                }
              }}
        });
    }}
