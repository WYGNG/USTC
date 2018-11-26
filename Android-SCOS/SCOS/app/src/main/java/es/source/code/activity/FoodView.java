package es.source.code.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.nfc.Tag;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONObject;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.fragment.ColdFoodViewFragment;
import es.source.code.fragment.DrinkFoodViewFragment;
import es.source.code.fragment.FoodViewFragment;
import es.source.code.fragment.SeaFoodViewFragment;
import es.source.code.http.MyPOSTHttpURLConnection;
import es.source.code.model.Food;
import es.source.code.model.Foods;
import es.source.code.model.MessageEvent;
import es.source.code.model.User;
import es.source.code.service.ServerObserverService;
import es.source.code.service.UpdateService;
import xq.scos.R;


import static es.source.code.model.Foods.coldfoods;
import static es.source.code.model.Foods.drinkfoods;
import static es.source.code.model.Foods.foods;
import static es.source.code.model.Foods.initfoods;
import static es.source.code.model.Foods.seafoods;
import static es.source.code.util.Util.modify;


public class FoodView extends AppCompatActivity {
    private static final int MIN_DISTANCE = 50; // 最小滑动距离
    private static final int MIN_VELOCITY = 20; // 最小滑动速度
    private User user;
    public static FoodViewFragment foodViewFragment;
    public static ColdFoodViewFragment coldFoodViewFragment;
    public static DrinkFoodViewFragment drinkFoodViewFragment;
    public static SeaFoodViewFragment seaFoodViewFragment;
    private int currentPosition = 0;
    private ListView mListView;
    private GestureDetector mGestureDetector;

    private Context context;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> list;
    private MyAdapter adapter;
    private String[] titles = {"冷菜", "热菜", "酒水","海鲜"};

    private myHandler sMessageHandler;
    private Messenger cMessenger;
    private Messenger sMessenger;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_view);
        //mGestureDetector = new GestureDetector(this, mGestureListener);

        foods.clear();
        coldfoods.clear();
        seafoods.clear();
        drinkfoods.clear();



        initfoods(coldfoods, 0);
        initfoods(foods, 1);
        initfoods(seafoods, 2);
        initfoods(drinkfoods, 3);

        list = new ArrayList<>();

        coldFoodViewFragment = new ColdFoodViewFragment();
        coldFoodViewFragment.initFoods(coldfoods);

        foodViewFragment = new FoodViewFragment();
        foodViewFragment.initFoods(foods);

        drinkFoodViewFragment = new DrinkFoodViewFragment();
        drinkFoodViewFragment.initFoods(drinkfoods);

        seaFoodViewFragment = new SeaFoodViewFragment();
        seaFoodViewFragment.initFoods(seafoods);

        list.add(coldFoodViewFragment);
        list.add(foodViewFragment);
        list.add(drinkFoodViewFragment);
        list.add(seaFoodViewFragment);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        //绑定
        tabLayout.setupWithViewPager(viewPager);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_food_view,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onPause() {
        list.clear();
        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch(item.getItemId()){
            case R.id.orderedfood:
                //
                intent = new Intent(FoodView.this,FoodOrderView.class);
                intent.putExtra("from","0");
                startActivity(intent);

                break;
            case R.id.listmenu:
                //
                intent = new Intent(FoodView.this,FoodOrderView.class);
                intent.putExtra("from","1");
                startActivity(intent);

                break;
            case R.id.service:
                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+120));
                startActivity(intent);
                break;

            case R.id.update:
                //服务代码
                intent = new Intent(this,ServerObserverService.class);

                if(item.getTitle().equals("启动实时更新")){

                    Log.d("实时更新开启","实时更新开启");



                    //thread.start();

                    startService(intent);
                    bindService(intent,connection,BIND_AUTO_CREATE);
                    //Toast.makeText(FoodView.this,"连接失败，请稍等重试",Toast.LENGTH_LONG).show();

                    item.setTitle("停止实时更新");



                }
                else if(item.getTitle().equals("停止实时更新")){

                    Log.d("实时更新关闭","实时更新关闭");
                    connection.onServiceDisconnected(getComponentName());
                    unbindService(connection);

                    //thread.interrupt();
                    stopService(intent);
                    //Toast.makeText(FoodView.this,"解除失败，请稍等重试",Toast.LENGTH_LONG).show();


                    item.setTitle("启动实时更新");

                }
                //sMessageHandler = new myHandler();
                //cMessenger = new Messenger(sMessageHandler);


                break;
            default:
                //
                intent = new Intent(FoodView.this,MainScreen.class);
                intent.putExtra("from","FromFoodView");
                startActivity(intent);
                break;
                //return super.onOptionsItemSelected(item);

        }
    return true;

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
            return titles[position];
        }
    }
    public ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("onServiceConnected", "连接建立");
            /*try {

                Message message = new Message();
                message.what = 1;
                sMessenger = new Messenger(service);
                sMessenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }*/


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("onServiceConnected", "连接断开");
            /*try {
                //sMessenger = new Messenger(service);
                Message message = new Message();
                message.what = 0;
                sMessenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }*/
        }
    };
    public class myHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            //Message message = new Message();
            final Bundle bundle = msg.getData();
            switch(msg.what){
                case 10:
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String name = bundle.getString("name");
                            int price = bundle.getInt("last");

                            Log.d(name,""+price);
                        }
                    });
                    thread.start();
                    break;

                default:
                    //
            }
            super.handleMessage(msg);

        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        final String name= messageEvent.getMessage();
        final int last = messageEvent.getLast();
        final int price = messageEvent.getPrice();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //modify(foods,name,last,);
                //modify(coldfoods,name,last);
                //modify(drinkfoods,name,last);
                //modify(seafoods,name,last);

                //TextView textView = findViewById(R.id.layout_list_item_tv_4);
                //textView.setText("库存:"+last);
            }
        });
        thread.start();
        if(modify(foods,name,last,price)){
            FoodViewFragment.listViewAdapter.notifyDataSetChanged();
        }
        else if(modify(coldfoods,name,last,price)){
            ColdFoodViewFragment.listViewAdapter.notifyDataSetChanged();
        }
        else if(modify(drinkfoods,name,last,price)){
            DrinkFoodViewFragment.listViewAdapter.notifyDataSetChanged();
        }
        else if(modify(seafoods,name,last,price)){
            SeaFoodViewFragment.listViewAdapter.notifyDataSetChanged();
        }
        Toast.makeText(FoodView.this,"更新完毕",Toast.LENGTH_LONG).show();


    }




}
