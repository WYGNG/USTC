package es.source.code.service;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Method;

import es.source.code.activity.FoodDetailed;
import es.source.code.activity.FoodView;
import es.source.code.activity.MainScreen;
import es.source.code.br.DeviceStartedListener;
import es.source.code.model.Food;
import es.source.code.model.Foods;
import xq.scos.R;

import static android.content.ContentValues.TAG;
import es.source.code.model.Foods;
/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class UpdateService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "es.source.code.service.action.FOO";
    private static final String ACTION_BAZ = "es.source.code.service.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "es.source.code.service.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "es.source.code.service.extra.PARAM2";

    private NotificationManager manager;
    private int Notification_ID;
    public UpdateService() {
        super("UpdateService");
        Log.d(TAG,"UpdateService");
    }

    @Override
    public void onCreate() {
        Log.d(TAG,"onCreateUpdateService");
        //Toast.makeText(this,"收到开机广播",Toast.LENGTH_LONG).show();
        super.onCreate();



    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, UpdateService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        NotificationChannel channel = new NotificationChannel("channel_1","123",NotificationManager.IMPORTANCE_LOW);
        manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        Notification.Builder builder = new Notification.Builder(this,"channel_1");
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.drawable.food_cold_dbjlbc);//设置图标
        builder.setTicker("!新品上架!");//手机状态栏的提示
        builder.setContentTitle("新品上架");//设置标题
        builder.setContentText("东北家拌凉菜,10,冷菜");//设置通知内容
        builder.setWhen(System.currentTimeMillis());//设置通知时间
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(defaultSoundUri);

        Intent intentCancel = new Intent(this, DeviceStartedListener.class);
        intentCancel.setAction("scos.intent.action.CLOSE_NOTIFICATION");
        PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(this, 0, intentCancel, PendingIntent.FLAG_ONE_SHOT);
        builder.setDeleteIntent(pendingIntentCancel);

        Intent intent_to = new Intent(this, MainScreen.class);
        /*Bundle bundle = new Bundle();
        bundle.putString("name", "东北家拌凉菜");
        bundle.putInt("id",R.drawable.food_cold_dbjlbc);
        intent_to.putExtras(bundle);*/

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent_to, 0);
        builder.setContentIntent(pendingIntent);//点击后的意图
        builder.setDefaults(Notification.DEFAULT_LIGHTS);//设置指示灯
        builder.setDefaults(Notification.DEFAULT_SOUND);//设置提示声音
        builder.setDefaults(Notification.DEFAULT_VIBRATE);//设置震动
        //collapseStatusBar(this);
        /*
        MediaPlayer mediaPlayer = MediaPlayer.create(this,Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        */
        Notification notification = builder.build();//4.1以上，以下要用getNotification()





        startForeground(Notification_ID,notification);
        manager.notify(Notification_ID, notification);

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }


    private void showNotification() {
        // TODO Auto-generated method stub

    }
    /**
     * 关闭下拉通知栏
     *
     * 需要添加权限：<uses-permission android:name="android.permission.EXPAND_STATUS_BAR" />
     *
     * @param context
     */
    public static void collapseStatusBar(Context context) {
        try {
            Object statusBarManager = context.getSystemService("statusbar");
            Method collapse;
            if (Build.VERSION.SDK_INT <= 16) {
                collapse = statusBarManager.getClass().getMethod("collapse");
            } else {
                collapse = statusBarManager.getClass().getMethod("collapsePanels");
            }
            collapse.invoke(statusBarManager);
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }



}
