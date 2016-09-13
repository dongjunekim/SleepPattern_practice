package whatdda.tabexamsolo.Component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import whatdda.tabexamsolo.callbackInterface.MyCallback;
import whatdda.tabexamsolo.callbackInterface.MyCallback2;
import whatdda.tabexamsolo.opretionProcess.TimeProcess;

/**
 * Created by dongj on 2016-04-21.
 */
public class BroadCastReciving extends BroadcastReceiver {

    private TimeProcess timeProcess = new TimeProcess();
    private int offSumTime, onSumTime;
    private MyCallback myCallback;
    private MyCallback2 myCallback2;
    private Boolean done = false;

    public void matchCallback(MyCallback myCallback) {
        this.myCallback = myCallback;

    }

    public void matchCallback(MyCallback2 myCallback2) {
        this.myCallback2 = myCallback2;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_SCREEN_ON.equals(intent.getAction())) {
            Log.d("Screen on", "BroadCastReceiver");
            int onTimes[] = timeProcess.Nowtime();
            onSumTime = timeProcess.Rendering(onTimes);
            int unRendTime[] = timeProcess.unRendering(onSumTime);

            for (int i = 0; i < onTimes.length; i++) {
                Log.d("broadCast Check_on", onTimes[i] + "");
                Log.d("broadCast Check2_on", onSumTime + "");
                Log.d("broadCast Check3_on", unRendTime[i] + "");
            }

            int sleepTime[] = timeProcess.initTime(onSumTime, offSumTime);
            Log.d("my SleepTime,broadcast", sleepTime[0] + "시 " + sleepTime[1] + "분 " + sleepTime[2] + "초");

            myCallback.isDone(done);
            myCallback2.getSleepTimes(sleepTime);
            done = true;
        }
        if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())) {
            Log.d("Screen off", "BroadCastReceiver");
            int offTimes[] = timeProcess.Nowtime();
            offSumTime = timeProcess.Rendering(offTimes);
            int unRendTime[] = timeProcess.unRendering(offSumTime);
            for (int i = 0; i < offTimes.length; i++) {
                Log.d("broadCast Check", offTimes[i] + "");
                Log.d("broadCast Check2", offSumTime + "");
                Log.d("broadCast Check3", unRendTime[i] + "");
            }
        }

    }


}
