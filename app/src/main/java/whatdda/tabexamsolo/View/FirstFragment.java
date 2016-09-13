package whatdda.tabexamsolo.View;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import whatdda.tabexamsolo.callbackInterface.MyCallback;
import whatdda.tabexamsolo.R;
import whatdda.tabexamsolo.Component.ServiceForCheck;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements MyCallback {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private boolean done = true;
    private Intent intent;

    public FirstFragment() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FirstFragment newInstance(int sectionNumber) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ServiceForCheck.reciving.matchCallback(this);
        final View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        intent = new Intent(getContext(), ServiceForCheck.class);
        Button btn = (Button) rootView.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startService(intent);
            }
        });
        return rootView;
    }

    @Override
    public void isDone(Boolean done) {
        this.done = done;
        Log.d("callback","OK");
        getContext().stopService(intent);
    }
}
