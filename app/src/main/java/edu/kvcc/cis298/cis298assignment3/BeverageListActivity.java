package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

public class BeverageListActivity extends FragmentActivity {

    private BeverageInventory mBeverageInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);
        mBeverageInventory = mBeverageInventory.getBeverageInventory(getApplicationContext());

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new BeverageListFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }



    }
}
