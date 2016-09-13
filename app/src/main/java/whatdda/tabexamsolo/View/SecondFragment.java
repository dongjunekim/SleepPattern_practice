package whatdda.tabexamsolo.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import whatdda.tabexamsolo.ViewProcess.RecyclerItem;
import whatdda.tabexamsolo.ViewProcess.RecyclerViewAdapter;
import whatdda.tabexamsolo.callbackInterface.MyCallback2;
import whatdda.tabexamsolo.R;
import whatdda.tabexamsolo.Component.ServiceForCheck;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment implements MyCallback2 {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private List<RecyclerItem> items = new ArrayList<>();
    private RecyclerItem item[] = new RecyclerItem[10];
    private RecyclerViewAdapter adapter;

    public SecondFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SecondFragment newInstance(int sectionNumber) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);


        ServiceForCheck.reciving.matchCallback(this);

        recyclerInit(rootView);
        return rootView;
    }

    @Override
    public void getSleepTimes(int[] sleepTime) {
        Log.d("callback ok", "Second Fragment");
        Log.d("take data", sleepTime[0] + " " + sleepTime[1] + " " + sleepTime[2] + " ");
        String sleepTimeData[] = new String[3];
        for (int i = 0; i < sleepTime.length; i++) {
            sleepTimeData[i] = String.valueOf(sleepTime[i]);
        }
        itemAdd(sleepTimeData);
    }

    private void recyclerInit(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter(getContext(), items, R.layout.recycler_item);
        recyclerView.setAdapter(adapter);
    }

    private void itemAdd(String sleepTimeData[]) {
        item[adapter.getItemCount()] = new RecyclerItem(getDate(), sleepTimeData[0], sleepTimeData[1], sleepTimeData[2]);
        items.add(adapter.getItemCount(), item[adapter.getItemCount()]);
        adapter.notifyItemInserted(adapter.getItemCount());

    }

    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd", java.util.Locale.getDefault());
        Date date = new Date();
        String strDate = dateFormat.format(date);
        return strDate;
    }


}
