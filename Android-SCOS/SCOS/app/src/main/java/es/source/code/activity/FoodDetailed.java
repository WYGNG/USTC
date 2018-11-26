package es.source.code.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import es.source.code.fragment.ColdFoodViewFragment;
import es.source.code.fragment.DrinkFoodViewFragment;
import es.source.code.fragment.FoodViewDetialFragment;
import es.source.code.fragment.FoodViewFragment;
import es.source.code.fragment.SeaFoodViewFragment;
import es.source.code.model.Food;
import es.source.code.model.Foods;
import xq.scos.R;

import static es.source.code.model.Foods.coldfoods;
import static es.source.code.model.Foods.drinkfoods;
import static es.source.code.model.Foods.foods;
import static es.source.code.model.Foods.seafoods;

public class FoodDetailed extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;
    private MyAdapter adapter;
    private List<Food> foods;
    private String[] title = {"详情"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detial_view);
        list = new ArrayList<>();

        //foodViewDetialFragment.initFoods(coldfoods);

        //foodViewDetialFragment.initFoods(foods);
        //title.addAll(foods);
        //foodViewDetialFragment.initFoods(seafoods);
        //title.addAll(seafoods);
        //foodViewDetialFragment.initFoods(drinkfoods);
        //title.addAll(drinkfoods);

        FoodViewDetialFragment foodViewDetialFragment = new FoodViewDetialFragment();

        list.add(foodViewDetialFragment);


        viewPager = (ViewPager) findViewById(R.id.food_detail_viewpager);
        tabLayout = (TabLayout) findViewById(R.id.food_detail_tablayout);
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //绑定
        tabLayout.setupWithViewPager(viewPager);


    }




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
            return title[position];
        }

    }




}
