package whatdda.tabexamsolo.ViewProcess;

/**
 * Created by 김동준 on 2016-05-17.
 */
public class RecyclerItem {
    String date, hour, min, sec;

    public RecyclerItem(String date,String hour,String min,String sec) {
        this.date = date;
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public String getDate() {
        return this.date;
    }
    public String gethour() {return this.hour;}

    public String getmin() {
        return this.min;
    }

    public String getsec() {
        return this.sec;
    }
}
