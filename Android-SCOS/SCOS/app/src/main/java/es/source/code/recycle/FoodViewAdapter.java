package es.source.code.recycle;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import xq.scos.R;

public class FoodViewAdapter extends RecyclerView.Adapter<FoodViewAdapter.ViewHolder> {

    private String [] captions;
    private int [] imageIds;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //定义ViewHolder
        private CardView cardView;
        public ViewHolder(CardView v){
            super(v);
            cardView = v;
        }

    }
    public FoodViewAdapter(String[] captions,int [] imageIds){
        this.captions = captions;
        this.imageIds = imageIds;

    }


    @Override
    public FoodViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        //创建视图
        CardView cv = (CardView)LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        //设置给定视图里面的值
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.iv_1);
        Drawable drawable= cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);

        TextView textView = (TextView)cardView.findViewById(R.id.tv_1);
        textView.setText(captions[position]);
    }

    @Override
    public int getItemCount(){
        //返回数据项的数量
        return captions.length;
    }


}



//适配器与回收视图暂时不用
        /*getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if(fragment instanceof FoodViewFragment){
                    currentPosition = 1;
                }
            }
        });*/

//适配器与列表视图
        /*mListView = (ListView)findViewById(R.id.food_view_lv_1);
        mListView.setAdapter(new ListViewAdapter(FoodView.this));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FoodView.this,"短pos:"+position,Toast.LENGTH_SHORT);
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FoodView.this,"长pos:"+position, Toast.LENGTH_LONG);
                return true;
            }
        });*/



    /*private void selectItem(int position){
        currentPosition = position;
        Fragment fragment;
        switch (position){
            case 1:
                fragment = new FoodViewFragment();
                break;

        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();

    }*/

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    GestureDetector.SimpleOnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float x = e1.getX() - e2.getX();

            if (x>0&&x > MIN_DISTANCE && Math.abs(velocityX) > MIN_VELOCITY) {
                Intent intent = new Intent(FoodView.this,FoodDetailed.class);
                intent.putExtra("from","FromFoodView");
                startActivity(intent);
            }
            else if (x<0&& -x > MIN_DISTANCE && Math.abs(velocityX) > MIN_VELOCITY) {
                Intent intent = new Intent(FoodView.this,MainScreen.class);
                intent.putExtra("from","FromFoodView");
                startActivity(intent);

            }
            finish();
            return false;
        }
    };//*/
    /*GestureDetector.SimpleOnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float x = e1.getX() - e2.getX();

            if (x>0&&x > MIN_DISTANCE && Math.abs(velocityX) > MIN_VELOCITY) {
                Intent intent = new Intent(FoodOrderView.this,FoodDetailed.class);
                intent.putExtra("from","FromFoodView");
                startActivity(intent);
            }
            else if (x<0&& -x > MIN_DISTANCE && Math.abs(velocityX) > MIN_VELOCITY) {
                Intent intent = new Intent(FoodOrderView.this,MainScreen.class);
                intent.putExtra("from","FromFoodView");
                startActivity(intent);

            }
            finish();
            return false;
        }
    };//*/

    /*private Messenger mMessager;
    private Handler cMessageHandler;
    public ServerObserverService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("onStartCommand","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("onBind","onBind");
        cMessageHandler = new MessageHandler();
        mMessager = new Messenger(cMessageHandler);
        return mMessager.getBinder();
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("onUnbind","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("onDestroy","onDestroy");
        super.onDestroy();
    }

    public class MessageHandler extends Handler {
        private Context mContext;

        @Override
        public void handleMessage(final Message msg) {

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    Message msgToScos = Message.obtain(msg);
                    //如果app运行
                    String mName = "SCOS";
                    mContext = getApplicationContext();
                    int uid = getPackageUid(mContext,mName);
                    if(uid > 0){
                        boolean rstA = isAppRunning(mContext, mName);
                        boolean rstB = isProcessRunning(mContext, uid);
                        if(rstA||rstB){
                            try
                            {
                                //模拟耗时
                                Thread.sleep(300);
                                Bundle bundle = new Bundle();
                                bundle.putString("name","东北家拌凉菜");
                                bundle.putInt("last",100);
                                msgToScos.setData(bundle);
                                msgToScos.what = 10;
                                msg.replyTo.send(msgToScos);
                                Log.d("thread","线程");
                            } catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            } catch (RemoteException e)
                            {
                                e.printStackTrace();
                            }

                            //指定包名的程序正在运行中
                        }else{
                            //指定包名的程序未在运行中
                        }
                    }else{
                        //应用未安装
                    }

                }
            });

            switch(msg.what){

                case 0:
                    //关闭多线程
                    thread.stop();
                    break;
                case 1:
                    //启动多线程
                    thread.start();
                    break;
                default:
                    //
            }
            super.handleMessage(msg);
        }
    }*/

    /*Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Message msgToScos = new Message();
                //如果app运行
                String mName = "SCOS";
                int uid = getPackageUid(mContext,mName);
                if(uid > 0){
                    boolean rstA = isAppRunning(mContext, mName);
                    boolean rstB = isProcessRunning(mContext, uid);
                    if(rstA||rstB){
                        try
                        {
                            //模拟耗时
                            Thread.sleep(300);

                            Bundle bundle = new Bundle();
                            bundle.putString("name","东北家拌凉菜");
                            bundle.putInt("last",100);
                            msgToScos.setData(bundle);
                            msgToScos.what = 10;
                            msg.replyTo.send(msgToScos);
                            Log.d("thread","线程");
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        } catch (RemoteException e)
                        {
                            e.printStackTrace();
                        }

                        //指定包名的程序正在运行中
                    }else{
                        //指定包名的程序未在运行中
                    }
                }else{
                    //应用未安装
                }

            }
        });*/
