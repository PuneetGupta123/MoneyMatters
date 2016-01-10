package dell.moneymatters;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;
/**
 * Created by dell on 1/10/2016.
 */
public class MoneyFeedAdapter extends RecyclerView.Adapter<MoneyFeedAdapter.ViewHolder> {

    ArrayList<MoneyFeedItem> moneyFeedItems;

    public MoneyFeedAdapter(ArrayList<MoneyFeedItem> moneyFeedItems) {
        this.moneyFeedItems = moneyFeedItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.money_feed_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        MoneyFeedItem item = moneyFeedItems.get(position);
        viewHolder.p_name.setText(item.getPersonName());
        viewHolder.feedItemID.setText(item.getId()+"");
        viewHolder.amount.setText(item.getAmount()+"");
        viewHolder.security.setText(item.getSecurityNeeded());
        viewHolder.rateOfInterest.setText(item.getRateOfInterest());
    }

    @Override
    public int getItemCount() {
        return moneyFeedItems.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        CircleImageView profile_pic;
        TextView rateOfInterest;
        TextView p_name;
        TextView amount;
        TextView feedItemID;
        TextView security;
        CardView cardView;
        public ViewHolder(View view) {
            super(view);
            profile_pic = (CircleImageView) view.findViewById(R.id.person_photo);
            p_name = (TextView) view.findViewById(R.id.person_name);
            amount = (TextView) view.findViewById(R.id.amount);
            feedItemID = (TextView) view.findViewById(R.id.item_id);
            rateOfInterest = (TextView) view.findViewById(R.id.ROI);
            security = (TextView) view.findViewById(R.id.security);
            cardView=(CardView) view.findViewById(R.id.card_view);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,p_name.getText(),Snackbar.LENGTH_LONG).show();
                }
            });
        }

    }
}
