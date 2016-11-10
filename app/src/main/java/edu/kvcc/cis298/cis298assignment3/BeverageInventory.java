package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by grant on 10/24/16.
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
    
    public static BeverageInventory getBeverageInventory(Context context)
    {
        if(theBeverageInventory == null)
            return new BeverageInventory(context);
        return theBeverageInventory;
    }
    
    public Beverage getBeverage(String ID){
        for (Beverage b:mInvitory)
        {
            if(ID.equals(b.getItemNumber()))
                return b;
        }
        return null;
    }
    
    public ArrayList<Beverage> getInvitory()
    {
        return mInvitory;
    }
    
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
