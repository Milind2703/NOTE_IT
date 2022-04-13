package com.example.note_it;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Note_Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "notesdb";
    private static final String DATABASE_TABLE = "notable";

    //Column name for database table
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_DATE = "date";
    private static final String KEY_TIME = "time";
    private static final String KEY_AUTHOR = "author";




    Note_Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATE TABLE nametame(id INT PRIMARY KEY, title TEXT, content TEXT, date TEXT, time TEXT, author TEXT)
        String query = "CREATE TABLE "+ DATABASE_TABLE + "("+ KEY_ID + " INT PRIMARY KEY" +
                KEY_TITLE + " TEXT,"+
                KEY_CONTENT + " TEXT,"+
                KEY_DATE + " TEXT,"+
                KEY_TIME + " TEXT,"+
                KEY_AUTHOR +" TEXT,"+ ")";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);




    }
}
