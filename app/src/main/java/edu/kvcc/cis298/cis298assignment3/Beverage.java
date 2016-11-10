package edu.kvcc.cis298.cis298assignment3;

import java.util.jar.Attributes;

/**
 * Created by grant on 10/24/16.
 */

public class Beverage {
    private String mName;
    private String mItemNumber;
    private String mPackSize;
    private double mPrice;
    private boolean mActive;

    public Beverage(String itemNumber, String name, String packSize, double price, boolean active){
        mName = name;
        mItemNumber = itemNumber;
        mPackSize = packSize;
        mPrice = price;
        mActive = active;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getItemNumber() {
        return mItemNumber;
    }

    public void setItemNumber(String mItemNumber) {
        this.mItemNumber = mItemNumber;
    }

    public String getPackSize() {
        return mPackSize;
    }

    public void setPackSize(String mPackSize) {
        this.mPackSize = mPackSize;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public boolean isActive() {
        return mActive;
    }

    public void setActive(boolean mActive) {
        this.mActive = mActive;
    }

    @Override
    public String toString() {
        return (mName);
    }
}
