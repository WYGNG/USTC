package es.source.code.activity;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import es.source.code.fragment.FoodViewFragment;
import es.source.code.fragment.OrderedViewFragment;
import es.source.code.fragment.OrderingViewFragment;
import es.source.code.model.Food;
import es.source.code.model.User;
import xq.scos.R;

import static es.source.code.model.Foods.ordered;
import static es.source.code.model.Foods.ordering;

public class FoodOrderView extends AppCompatActivity {
    private static final int MIN_DISTANCE = 50; // 最小滑动距离
    private static final int MIN_VELOCITY = 20; // 最小滑动速度
    User user;
    GestureDetector mGestureDetector;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = { "未下订单","已下订单"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_order_view);
        //mGestureDetector = new GestureDetector(this, mGestureListener);
        OrderedViewFragment orderedViewFragment = new OrderedViewFragment();
        orderedViewFragment.initFoods(ordered);
        OrderingViewFragment orderingViewFragment = new OrderingViewFragment();
        orderingViewFragment.initFoods(ordering);

        list = new ArrayList<>();

        list.add(orderingViewFragment);
        list.add(orderedViewFragment);


        Intent intent = getIntent();

        viewPager = (ViewPager) findViewById(R.id.order_viewpager);

        tabLayout = (TabLayout) findViewById(R.id.order_tablayout);
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //绑定
        tabLayout.setupWithViewPager(viewPager);
        if(intent.getExtras().get("from").equals("0")){viewPager.setCurrentItem(0);}
        else if(intent.getExtras().get("from").equals("1")){viewPager.setCurrentItem(1);}


    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }*/



    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
    public void setOrdered(List<Food> list){

        //ordered = list;
    }
    public void setOrdering(List<Food> list){

        //ordering = list;
    }


}
