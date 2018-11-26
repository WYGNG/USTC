package es.source.code.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import es.source.code.http.MyPOSTHttpURLConnection;
import es.source.code.model.MessageEvent;

import static android.content.ContentValues.TAG;
import static es.source.code.activity.FoodView.coldFoodViewFragment;
import static es.source.code.activity.FoodView.drinkFoodViewFragment;
import static es.source.code.activity.FoodView.foodViewFragment;
import static es.source.code.activity.FoodView.seaFoodViewFragment;
import static es.source.code.model.Foods.coldfoods;
import static es.source.code.model.Foods.drinkfoods;
import static es.source.code.model.Foods.foods;
import static es.source.code.model.Foods.seafoods;
import static es.source.code.util.Util.modify;

public class ServerObserverService extends Service {

    private myHandler cMessageHandler;
    private Messenger mMessenger;
    private Messenger cMessenger;
    private Thread thread;
    public ServerObserverService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind");
        /*
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    int i = 20;
                    while(i<=100){

                        EventBus.getDefault().post(new MessageEvent("东北家拌凉菜",i++));
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.d(TAG,"线程运行中");

            }
        });
        */

        Thread thread = null;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {

                //sendJson();
                String url = MyPOSTHttpURLConnection.BASE_URL + "/FoodUpdateService";
                Map<String,String > parms = new HashMap<String, String>();
                String result = MyPOSTHttpURLConnection.getContextByHttp(url,parms);
                Log.d("result",result);
                try{
                    JSONArray json = new JSONArray(result);

                    for(int i = 0; i < json.length(); i++){

                        String name = json.getJSONObject(i).getString("name");
                        int last = json.getJSONObject(i).getInt("last");
                        Log.d("name",name);
                        Log.d("last",""+last);
                        int price = json.getJSONObject(i).getInt("price");
                        String category = json.getJSONObject(i).getString("category");
                        Log.d("price",""+price);
                        Log.d("category",category);

                        EventBus.getDefault().post(new MessageEvent(name,last,price));

                        //TextView tv_1 = findViewById(R.id.layout_list_item_tv_1);
                        //TextView tv_2 = findViewById(R.id.layout_list_item_tv_2);
                        //TextView tv_3 = findViewById(R.id.layout_list_item_tv_3);
                        //TextView tv_4 = findViewById(R.id.layout_list_item_tv_4);
                        //tv_1.setText("菜名:"+name);
                        //tv_2.setText("单价"+price);
                        //tv_3.setText("单价"+price);
                        //tv_4.setText("库存:"+last);

                    }


                }catch (Exception e){
                    e.printStackTrace();
                }



            }



        });
        thread.start();
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        //cMessageHandler = new myHandler();
        //mMessenger = new Messenger(cMessageHandler);
        //return mMessenger.getBinder();
        return null;

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG,"onUnbind");

        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        Log.d("onDestroy","onDestroy");
        //thread.interrupt();
        super.onDestroy();
    }


    private class myHandler extends Handler {
        private IBinder iBinder;
        private Context mContext;
        @Override
        public void handleMessage(Message msg) {
            final Message message = new Message();
            switch(msg.what){
                case 0:
                    //关闭多线程
                    Log.d(TAG,"多线程关");
                    break;
                case 1:
                    //启动多线程
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG,"Thread");

                            //如果app运行
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Bundle bundle = new Bundle();
                            bundle.putString("name","东北家拌凉菜");
                            bundle.putInt("last",100);
                            message.setData(bundle);
                            message.what = 10;
                            Log.d(TAG,"线程运行中");
                            sendMessage(message);

                        }
                    });
                    thread.start();//调试
                    Log.d(TAG,"多线程开");


                    break;
                default:
                    //
            }
            super.handleMessage(msg);

        }

    }




}
