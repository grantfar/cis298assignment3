package edu.kvcc.cis298.cis298assignment3;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by grant on 10/24/16.
 */

public class BeverageListFragment extends Fragment {
    private RecyclerView mBeverageRecyclerView;

    private beverageAdapter mBeverageAdapter;

    private  BeverageInventory mBeverages;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.beverage_list_fragment,container,false);

        mBeverageRecyclerView = (RecyclerView) v.findViewById(R.id.beverage_recycler_view);

        mBeverageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        mBeverageRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),RecyclerView.VERTICAL));

        mBeverages = BeverageInventory.getBeverageInventory(getContext());
        updateView();

        return v;


    }

    private void updateView()
    {
       beverageAdapter mBeverageAdapter = new beverageAdapter(mBeverages.getInvitory());
        mBeverageRecyclerView.setAdapter(mBeverageAdapter);
    }

    private class beverageHolder extends  RecyclerView.ViewHolder
    implements View.OnClickListener
    {
        public TextView mTextTitleView;
        public TextView mPriceTextView;
        public TextView mNumberTextView;
        public int mPosition;
        public Beverage mBeverage;

        public beverageHolder(View itemView) {
            super(itemView);
            mTextTitleView = (TextView) itemView.findViewById(R.id.nameTextViewList);
            mPriceTextView = (TextView) itemView.findViewById(R.id.priceTextViewList);
            mNumberTextView = (TextView) itemView.findViewById(R.id.itemNumberTextViewList);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            startActivity(BeverageActivity.getIntent(getActivity(),mBeverage.getItemNumber()));
        }
    }

    private class beverageAdapter extends  RecyclerView.Adapter
    {


        private List<Beverage> mBeverages;

        private beverageAdapter(List<Beverage> Beverages)
        {
            mBeverages = Beverages;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.list_item,parent,false);

            return new beverageHolder(v);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Beverage bev = mBeverages.get(position);
            ((beverageHolder) holder).mBeverage = bev;
            ((beverageHolder) holder).mTextTitleView.setText(bev.getName());
            ((beverageHolder) holder).mPriceTextView.setText(NumberFormat.getCurrencyInstance().format(bev.getPrice()));
            ((beverageHolder) holder).mNumberTextView.setText(bev.getItemNumber());
            ((beverageHolder) holder).mPosition = position;
        }

        @Override
        public int getItemCount() {
            return mBeverages.size();
        }
    }
}
