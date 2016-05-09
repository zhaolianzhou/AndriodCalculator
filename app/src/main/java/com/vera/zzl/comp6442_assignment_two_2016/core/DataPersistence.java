package com.vera.zzl.comp6442_assignment_two_2016.core;

import android.util.Log;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <h1>Addition</h1>
 * TODO Class Description
 *
 * @author Pubudu Dissanayake | comp6442_assignment_two_2016
 * @version 1.0
 * @since 9/05/2016
 */
public class DataPersistence {
    private ArrayList<String> expressionCollection;
    private File fileDir;

    public DataPersistence(File fileDir) {
        readExpressionsFromFile(fileDir);
        this.fileDir = fileDir;
    }

    /**
     *
     * @param fileDir
     */
    public void readExpressionsFromFile(File fileDir){
        File dir = fileDir;
        File historyFile = new File(dir, "ExpressionHistory.txt");
        try{
            expressionCollection = new ArrayList<String>(FileUtils.readLines(historyFile));
        } catch (IOException e) {
            expressionCollection = new ArrayList<String>();
        }
    }

    /**
     *
     * @param fileDir
     */
    private void writeExpressionsFromFile(File fileDir){
        File dir = fileDir;
        File historyFile = new File(dir, "ExpressionHistory.txt");
        try{
            FileUtils.writeLines(historyFile, expressionCollection);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    public void addHistoryData(String expression){
        Log.d("DataPersistence", "Expression String: "+ expression);
        expressionCollection.add(expression);
        writeExpressionsFromFile(fileDir);
    }

    public void readValues (){
        for (String s : expressionCollection){
            Log.d("DataPersistence", "Expression String: "+ s);
        }
    }

    public void clearHistoryValues(){
        expressionCollection = new ArrayList<String>();


    }
}
