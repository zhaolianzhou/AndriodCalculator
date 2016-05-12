package com.vera.zzl.calculator.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.vera.zzl.calculator.Constants;

/**
 * <h1>Addition</h1>
 * TODO Class Description
 *
 * @author Pubudu Dissanayake | comp6442_assignment_two_2016
 * @version 1.0
 * @since 10/05/2016
 */
public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public DataBaseOpenHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_EXPRESSIONS);

    }
}
