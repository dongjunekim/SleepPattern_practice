package whatdda.tabexamsolo.Component;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by dongj on 2016-04-21.
 */
public class ServiceForCheck extends Service {

    public static BroadCastReciving reciving = new BroadCastReciving();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("서비스", "실행중");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(reciving, intentFilter);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        unregisterReceiver(reciving);
        Log.d("서비스", "종료");

        super.onDestroy();
    }
}
