package whatdda.tabexamsolo.opretionProcess;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dongj on 2016-03-15.
 */
public class TimeProcess {
    private int sumTime;

    public int[] Nowtime() {
        int times[] = new int[3];

        long getTime = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("hh:mm:ss");
        String nowtime = dayTime.format(new Date(getTime));

        String nowtimes[];

        for (int i = 0; i < times.length; i++) {
            nowtimes = new String(nowtime).split(":");
            times[i] = Integer.parseInt(nowtimes[i]);
            Log.d("times+" + i, times[i] + "");
        }
        return times;
    }

    public int Rendering(int times[]) {
        sumTime = times[0] * 3600;
        sumTime = sumTime + times[1] * 60;
        sumTime = sumTime + times[2];
        return sumTime;
    }

    public int[] unRendering(int arrTime) {
        int nowtime[] = new int[3];
        nowtime[0] = arrTime / 3600;
        nowtime[1] = (arrTime - (nowtime[0] * 3600)) / 60;
        nowtime[2] = arrTime % 60;
        return nowtime;
    }

    public int[] initTime(int onSumTime, int offSumTime) {
        return unRendering(onSumTime - offSumTime);
    }

}
