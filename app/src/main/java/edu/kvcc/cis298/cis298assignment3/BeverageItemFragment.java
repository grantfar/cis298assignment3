package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by grant on 11/9/16.
 */

public class BeverageItemFragment extends Fragment {
    //class variables
    private EditText mNameEditText;
    private EditText mPriceEditText;
    private EditText mItemNumberEditText;
    private EditText mPackageEditText;
    private CheckBox mActiveCheckbox;
    private Beverage mBev;
    //final string key for beverage item number
    private static final String ITEM_NUMBER_STRING = "beverage_id";
    //returns a new instase of BeverageItemFragment from the provided
    public static BeverageItemFragment newInstance(String itemNumber){
        Bundle args = new Bundle();
        BeverageItemFragment newFragment = new BeverageItemFragment();
        args.putString(ITEM_NUMBER_STRING,itemNumber);
        newFragment.setArguments(args);
        return newFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beverage_item_fragment,container,false);
        //instantate variables
        mNameEditText = (EditText) view.findViewById(R.id.nameEditTextItem);
        mPriceEditText= (EditText) view.findViewById(R.id.priceEditTextItem);
        mItemNumberEditText = (EditText) view.findViewById(R.id.itemNumberEditTextItem);
        mPackageEditText = (EditText) view.findViewById(R.id.packEditTextItem);
        mActiveCheckbox = (CheckBox) view.findViewById(R.id.ActiveCheckbox);


        mBev = BeverageInventory.getBeverageInventory(getActivity()).getBeverage(getArguments().getString(ITEM_NUMBER_STRING));

        //set variable values
        mNameEditText.setText(mBev.getName());
        mItemNumberEditText.setText(mBev.getItemNumber());
        mPriceEditText.setText(String.valueOf(mBev.getPrice()));
        mPackageEditText.setText(mBev.getPackSize());
        mActiveCheckbox.setChecked(mBev.isActive());

        //listeners
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                mBev.setName(mNameEditText.getText().toString());
            }
        });
        mPriceEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }
            @Override
            public void afterTextChanged(Editable editable) {
                mBev.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
            }
        });

        mPackageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }
            @Override
            public void afterTextChanged(Editable editable) {
                mBev.setPackSize(mPackageEditText.getText().toString());
            }
        });

        mItemNumberEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                mBev.setItemNumber(mItemNumberEditText.getText().toString());
            }
        });
        mActiveCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBev.setActive(mActiveCheckbox.isChecked());
            }
        });
        return view;

    }
}
