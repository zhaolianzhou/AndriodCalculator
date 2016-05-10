package com.vera.zzl.calculator;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.vera.zzl.calculator.core.DataBaseOpenHelper;

/**
 * <h1>Addition</h1>
 * TODO Class Description
 *
 * @author Pubudu Dissanayake | comp6442_assignment_two_2016
 * @version 1.0
 * @since 10/05/2016
 */
public class ExpressionsProvider extends android.content.ContentProvider {

    SQLiteDatabase sqLiteDatabase;

    // Constant to identify the requested operation
    private static final int EXPRESSION = 1;
    private static final int EXPRESSION_ID = 2;
    // parse a URI and request which operation has requested.
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(Constants.AUTHORITY, Constants.BASE_PATH, EXPRESSION);
        // # mark is a wild card, any numerical value. which means it looking for a particular note.
        URI_MATCHER.addURI(Constants.AUTHORITY, Constants.BASE_PATH + "/#", EXPRESSION_ID);
    }

    @Override
    public boolean onCreate() {
        DataBaseOpenHelper helper = new DataBaseOpenHelper(getContext());
        sqLiteDatabase = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return sqLiteDatabase.query(Constants.TABLE_EXPRESSIONS,Constants.ALL_COLUMNS,
        selection,null,null,null,
                Constants.EXPRESSION_CREATED + " DESC");
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = sqLiteDatabase.insert(Constants.TABLE_EXPRESSIONS,
                null,values);
        return Uri.parse(Constants.BASE_PATH+"/"+id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return sqLiteDatabase.delete(Constants.TABLE_EXPRESSIONS,selection,selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return sqLiteDatabase.update(Constants.TABLE_EXPRESSIONS,values,selection,selectionArgs);
    }
}
