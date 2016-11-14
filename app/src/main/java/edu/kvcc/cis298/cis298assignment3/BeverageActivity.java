package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * Created by grant on 11/2/16.
 */

public class BeverageActivity extends FragmentActivity{
    private ViewPager mViewPager;
    private BeverageInventory mBeverageInventory;
    private static final String EXTRA_BEVERAGE_NUMBER = "edu.kvcc.cis298.cis289assignment3.beveragenumber";

    //creates intent for launching Activity
    public static Intent getIntent(Context context, String ProductNumber){
        Intent creationIntent = new Intent(context,BeverageActivity.class);
        creationIntent.putExtra(EXTRA_BEVERAGE_NUMBER,ProductNumber);
        return creationIntent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beverage_detail_view);
        mBeverageInventory = BeverageInventory.getBeverageInventory(this);
        String bevNumber = getIntent().getStringExtra(EXTRA_BEVERAGE_NUMBER);

        //creating view pager
        mViewPager = (ViewPager) findViewById(R.id.bev_pager_view);

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return BeverageItemFragment.newInstance(mBeverageInventory.getInvitory().get(position).getItemNumber());
            }

            @Override
            public int getCount() {
                return mBeverageInventory.getInvitory().size();
            }
        });
        mViewPager.setCurrentItem(mBeverageInventory.getInvitory().indexOf(mBeverageInventory.getBeverage(bevNumber)));
    }
}
