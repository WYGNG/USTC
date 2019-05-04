package es.source.code.br;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import es.source.code.service.UpdateService;

import static android.content.ContentValues.TAG;

public class DeviceStartedListener extends BroadcastReceiver {
    private static final String TAG = "DeviceStartedListener";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d(TAG, "onReceive");

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            Intent serviceIntent = new Intent(context, UpdateService.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(serviceIntent);
            }
        }
        else if (intent.getAction().equals("scos.intent.action.CLOSE_NOTIFICATION")) {
            NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context
                        .NOTIFICATION_SERVICE);
                notifyManager.cancel(intent.getIntExtra("notification_id", 0));
        }
    }





}
