package com.vera.zzl.comp6442_assignment_two_2016.core;

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
    public void writeExpressionsFromFile(File fileDir){
        File dir = fileDir;
        File historyFile = new File(dir, "ExpressionHistory.txt");
        try{
            FileUtils.writeLines(historyFile, expressionCollection);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

}
