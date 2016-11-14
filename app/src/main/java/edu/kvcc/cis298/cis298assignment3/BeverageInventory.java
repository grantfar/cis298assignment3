package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by grant on 10/24/16.
 * Singleton contains bevarage ArrayList
 */

public class BeverageInventory {

    private static BeverageInventory theBeverageInventory;

    private ArrayList<Beverage> mInvitory;

    private CsvDataParcer BeverageParcer;

    private BeverageInventory(Context context)
    {
        theBeverageInventory = this;
        mInvitory = new ArrayList<>();
        BeverageParcer = new CsvDataParcer(context);
        setInvitory();
    }

    //reads in the csv, formats it, and then sets it to the invitory
    private void setInvitory()
    {
        try {
            ArrayList<String[]> tmpInvitory = BeverageParcer.GetData();
            for (String[] s:tmpInvitory)
            {
                try {
                    mInvitory.add(new Beverage(s[0],s[1],s[2],Double.parseDouble(s[3]),Boolean.parseBoolean(s[4])));

                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //sends the instace of beverage invitory or creates a new one
    public static BeverageInventory getBeverageInventory(Context context)
    {
        if(theBeverageInventory == null)
            return new BeverageInventory(context);
        return theBeverageInventory;
    }

    //returns a beverage from the invitory
    public Beverage getBeverage(String ID){
        for (Beverage b:mInvitory)
        {
            if(ID.equals(b.getItemNumber()))
                return b;
        }
        return null;
    }

    //returns the Beverage arrayList
    public ArrayList<Beverage> getInvitory()
    {
        return mInvitory;
    }
    //adds a new bevarage
    public void addBeverage(Beverage bev)
    {
        mInvitory.add(bev);
    }
    public void removeBeverage(String ID){
        for (Beverage b:mInvitory)
        {
            if(ID == b.getItemNumber())
                mInvitory.remove(b);
            return;
        }
    }
}
