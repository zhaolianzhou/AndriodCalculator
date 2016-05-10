package com.vera.zzl.calculator;

import android.net.Uri;

/**
 * <h1>Addition</h1>
 * TODO Class Description
 *
 * @author Pubudu Dissanayake | comp6442_assignment_two_2016
 * @version 1.0
 * @since 10/05/2016
 */
public final class Constants {

    public static final String DATABASE_NAME = "history.db";
    public static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns
    public static final String TABLE_EXPRESSIONS = "expressions";
    public static final String EXPRESSION_ID = "_id";
    public static final String EXPRESSION_TEXT = "expression";
    public static final String EXPRESSION_CREATED = "expressionCreated";

    //SQL to create table
    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_EXPRESSIONS + " (" +
                    EXPRESSION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    EXPRESSION_TEXT + " TEXT, " +
                    EXPRESSION_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";
    public static final String[] ALL_COLUMNS = {EXPRESSION_ID, EXPRESSION_TEXT, EXPRESSION_CREATED};

    public static final String AUTHORITY = "com.vera.zzl.calculator.core.expressionsprovider";
    //entire data set
    public static final String BASE_PATH = "expressions";
    // URI that identify the content provider
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);


    public static final int HISTORY_REQUEST_CODE = 404;
    public static final String CONTENT_ITEM_TYPE = "expression";
}
