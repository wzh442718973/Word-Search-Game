package com.refined.stylish.sanhdieu.data.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.refined.stylish.sanhdieu.domain.data.source.WordDataSource;
import com.refined.stylish.sanhdieu.domain.model.Word;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by abdularis on 18/07/17.
 */

public class WordSQLiteDataSource implements WordDataSource {

    private DbHelper mHelper;

    @Inject
    public WordSQLiteDataSource(DbHelper helper) {
        mHelper = helper;
    }

    @Override
    public void getWords(Callback callback) {
        SQLiteDatabase db = mHelper.getReadableDatabase();

        String cols[] = {
                DbContract.WordBank._ID,
                DbContract.WordBank.COL_STRING
        };

        Cursor c = db.query(DbContract.WordBank.TABLE_NAME, cols, null, null, null, null, null);

        List<Word> wordList = new ArrayList<>();
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {

                wordList.add(new Word(c.getInt(0), c.getString(1)));

                c.moveToNext();
            }
        }

        c.close();
        callback.onWordsLoaded(wordList);
    }
}
