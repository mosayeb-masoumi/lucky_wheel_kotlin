package com.example.testkotlin.luckyWheel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.example.testkotlin.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LuckyWheelJavaActivity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=r8haL7agB_E

    LuckyWheel luckyWheel;
    List<WheelItem> wheelItemList;
    String points;

    Button btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_wheel_java);

        luckyWheel = findViewById(R.id.luckyWheel);
        btnPlay = findViewById(R.id.btnPlay);




        wheelItemList = new ArrayList<>();

        WheelItem wheelItem1 = new WheelItem(
                ResourcesCompat.getColor(getResources(), R.color.colorAccent , null) ,
                BitmapFactory.decodeResource(getResources(), R.drawable.setting) , "0");

        WheelItem wheelItem2 = new WheelItem(
                ResourcesCompat.getColor(getResources(), R.color.colorPrimary , null) ,
                BitmapFactory.decodeResource(getResources(), R.drawable.setting) , "1 0");

        WheelItem wheelItem3 = new WheelItem(
                ResourcesCompat.getColor(getResources(), R.color.colorAccent , null) ,
                BitmapFactory.decodeResource(getResources(), R.drawable.setting) , "2 0");

        WheelItem wheelItem4 = new WheelItem(
                ResourcesCompat.getColor(getResources(), R.color.colorPrimary , null) ,
                BitmapFactory.decodeResource(getResources(), R.drawable.setting) , "3 0");

        WheelItem wheelItem5 = new WheelItem(
                ResourcesCompat.getColor(getResources(), R.color.colorAccent , null) ,
                BitmapFactory.decodeResource(getResources(), R.drawable.setting) , "4 0");

        WheelItem wheelItem6 = new WheelItem(
                ResourcesCompat.getColor(getResources(), R.color.colorPrimary , null) ,
                BitmapFactory.decodeResource(getResources(), R.drawable.setting) , "5 0");


        wheelItemList.add(wheelItem1);
        wheelItemList.add(wheelItem2);
        wheelItemList.add(wheelItem3);
        wheelItemList.add(wheelItem4);
        wheelItemList.add(wheelItem5);
        wheelItemList.add(wheelItem6);


        luckyWheel.addWheelItems(wheelItemList);


        luckyWheel.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                WheelItem itemSelected = wheelItemList.get(Integer.parseInt(points) - 1);
                String point_amount = itemSelected.text;

                Toast.makeText(LuckyWheelJavaActivity.this, point_amount, Toast.LENGTH_SHORT).show();
            }
        });


        btnPlay.setOnClickListener(view -> {
            Random random = new Random();
            points = String.valueOf(random.nextInt(6));  // number 6 == 6 is the length of wheelItemList

            if(points.equals("0")){
                points = String.valueOf(1);
            }

            luckyWheel.rotateWheelTo(Integer.parseInt(points));
        });



    }
}