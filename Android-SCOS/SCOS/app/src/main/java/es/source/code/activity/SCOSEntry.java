package es.source.code.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

import android.view.MotionEvent;
import android.widget.Toast;

import es.source.code.service.UpdateService;
import xq.scos.R;

import static es.source.code.model.Foods.coldfoods;
import static es.source.code.model.Foods.drinkfoods;
import static es.source.code.model.Foods.foods;
import static es.source.code.model.Foods.initfoods;
import static es.source.code.model.Foods.seafoods;

public class SCOSEntry extends AppCompatActivity {

    private static final int MIN_DISTANCE = 50; // 最小滑动距离
    private static final int MIN_VELOCITY = 20; // 最小滑动速度
    private GestureDetector mGestureDetector;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    GestureDetector.SimpleOnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float x = e1.getX() - e2.getX();

            if (x > MIN_DISTANCE && Math.abs(velocityX) > MIN_VELOCITY) {
                showToast(getResources().getString(R.string.welcome));//显示欢迎

                SharedPreferences.Editor editor = getSharedPreferences("User",MODE_PRIVATE).edit();
                editor.putInt("loginState",0);
                editor.commit();

                Intent intent = new Intent(SCOSEntry.this,MainScreen.class);
                intent.putExtra("from","FromEntry");
                startActivity(intent);

                finish();
            }
            return false;
        }
    };//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        initfoods(coldfoods, 0);
        initfoods(foods, 1);
        initfoods(seafoods, 2);
        initfoods(drinkfoods, 3);
        mGestureDetector = new GestureDetector(this, mGestureListener);
    }
    public void toMainscreen(View view){
        SharedPreferences.Editor editor = getSharedPreferences("User",MODE_PRIVATE).edit();
        editor.putInt("loginState",1);
        editor.commit();
        Intent intent = new Intent(this,MainScreen.class);
        Intent intent_service = new Intent(this,UpdateService.class);
        startService(intent_service);
        intent.putExtra("from","FromEntryClick");
        startActivity(intent);
    }
    public void showToast(String input) {
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }


}
