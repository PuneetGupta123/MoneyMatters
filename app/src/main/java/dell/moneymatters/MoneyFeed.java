package dell.moneymatters;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFeed extends Fragment {

    MoneyFeedAdapter adapter;
    ArrayList<MoneyFeedItem> moneyFeedItems;
    View view;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    public MoneyFeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_money_feed, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.my_recycler_view);
        moneyFeedItems=new ArrayList<>();
        initializeData();
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MoneyFeedAdapter(moneyFeedItems);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void initializeData()
    {
        moneyFeedItems.add(new MoneyFeedItem(1,"dfjfd",1,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(2,"dfjfd",10,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(3,"dfjfd",11,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(4,"dfjfd",1,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(5,"dfjfd",1,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(89,"dfd",1,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(4874,"dfjfd",1,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(1830,"dfjfd",1,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(10,"dfjfd",1,"sjsdjiee","sdjsyjs"));
        moneyFeedItems.add(new MoneyFeedItem(111,"dfjfd",1,"sjsdjiee","sdjsyjs"));
    }

}
