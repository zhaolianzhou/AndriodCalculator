package com.vera.zzl.calculator;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.File;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor>{
    private ArrayList<String> expressionCollection;
    private File fileDir;
    private ArrayAdapter<String> historyItemsAdapter;
    private CursorAdapter cursorAdapter;
    private ListView listView;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        String[] from = { Constants.EXPRESSION_TEXT};
        int[] to = {R.id.lvItems};
        cursorAdapter = new SimpleCursorAdapter(this,
                R.layout.history_list_items,null,from,to,0);
        listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(cursorAdapter);
        getLoaderManager().initLoader(0,null,this);

        int[] colors = {0, 0xFFFF0000, 0};
        listView.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        listView.setDividerHeight(1);
        listView.setOnItemClickListener(getOnItemClickListener());
    }

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);
                String selectedFromList = cursor.getString(cursor.getColumnIndex(Constants.EXPRESSION_TEXT));
                Log.d("HistoryActivity", "Clicked Expression: "+ selectedFromList);
                Intent tempIntent = new Intent(getApplicationContext(), MainActivity.class);
                tempIntent.putExtra("SELECTED_EXPRESSION", selectedFromList);
                setResult(Activity.RESULT_OK,tempIntent);
                finish();
            }
        };
    }

    /**
     *  Following three methods are callback methods
     */

    /**
     *
     * @param id
     * @param args
     * @return
     */
    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, Constants.CONTENT_URI, null, null, null, null);
    }

    /**
     *
     * @param loader
     * @param data
     */
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);
    }

    /**
     *
     * @param loader
     */
    @Override
    public void onLoaderReset(Loader<Cursor>  loader) {
        cursorAdapter.swapCursor(null);
    }


    /**
     * Recall LoaderManager to restart/refresh the content
     */
    public void recallLoader() {
        getLoaderManager().restartLoader(0, null, this);
    }

}
