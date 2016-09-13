package whatdda.tabexamsolo.ViewProcess;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import whatdda.tabexamsolo.R;

/**
 * Created by 김동준 on 2016-05-17.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<RecyclerItem> items;
    private int item_layout;

    public RecyclerViewAdapter(Context context, List<RecyclerItem> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RecyclerItem item = items.get(position);
        holder.dateText.setText(item.getDate());
        holder.hourText.setText(item.gethour());
        holder.minText.setText(item.getmin());
        holder.secText.setText(item.getsec());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateText, hourText, minText, secText;

        public ViewHolder(View itemView) {
            super(itemView);
            dateText = (TextView) itemView.findViewById(R.id.dateText);
            hourText = (TextView) itemView.findViewById(R.id.hourText);
            minText = (TextView) itemView.findViewById(R.id.minText);
            secText = (TextView) itemView.findViewById(R.id.secText);
        }
    }
}
