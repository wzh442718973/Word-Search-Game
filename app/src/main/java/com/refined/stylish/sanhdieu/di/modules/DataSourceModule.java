package com.refined.stylish.sanhdieu.di.modules;

import android.content.Context;

import com.refined.stylish.sanhdieu.data.sqlite.DbHelper;
import com.refined.stylish.sanhdieu.data.sqlite.GameRoundSQLiteDataSource;
import com.refined.stylish.sanhdieu.data.sqlite.WordSQLiteDataSource;
import com.refined.stylish.sanhdieu.data.xml.WordXmlDataSource;
import com.refined.stylish.sanhdieu.domain.data.source.GameRoundDataSource;
import com.refined.stylish.sanhdieu.domain.data.source.WordDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abdularis on 18/07/17.
 */

@Module
public class DataSourceModule {

    @Provides
    @Singleton
    DbHelper provideDbHelper(Context context) {
        return new DbHelper(context);
    }

    @Provides
    @Singleton
    GameRoundDataSource provideGameRoundDataSource(DbHelper dbHelper) {
        return new GameRoundSQLiteDataSource(dbHelper);
    }

//    @Provides
//    @Singleton
//    WordDataSource provideWordDataSource(DbHelper dbHelper) {
//        return new WordSQLiteDataSource(dbHelper);
//    }

    @Provides
    @Singleton
    WordDataSource provideWordDataSource(Context context) {
        return new WordXmlDataSource(context);
    }

}
