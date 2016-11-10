package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Created by grant on 10/24/16.
 */

public class CsvDataParcer {
    private BufferedReader CSVreader;

    public CsvDataParcer(Context context) {
            CSVreader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.beverage_list)));
    }

    public ArrayList<String[]> GetData() throws IOException {
        ArrayList<String[]> parcedCsv = new ArrayList<>();
        String line;
        while ((line = CSVreader.readLine())!=null && !line.trim().isEmpty())
        {
            parcedCsv.add(line.split(","));
        }
        CSVreader.close();
        return parcedCsv;
    }
}
