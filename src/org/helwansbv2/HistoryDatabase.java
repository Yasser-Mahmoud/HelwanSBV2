package org.helwansbv2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class HistoryDatabase extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "Helwan SB v2";
	private static final int DATABASE_VERSION = 1;
    
    private static final String TABLE_INBOX = "inbox";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_CONTENT = "content";
 
    public HistoryDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE = "CREATE TABLE " + TABLE_INBOX + "("
                + COLUMN_DATE + " TEXT," + COLUMN_TIME + " TEXT," + COLUMN_CONTENT + " TEXT" + ")";
        db.execSQL(TABLE_CREATE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INBOX);
 
        // Create table again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new message
    void addMessage(String[] message) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, message[0]); // Receiving date
        values.put(COLUMN_TIME, message[1]); //Receiving time
        values.put(COLUMN_CONTENT, message[2]); // Message
 
        // Inserting Row
        db.insert(TABLE_INBOX, null, values);
        db.close(); // Closing database connection   
    }
    
    public String getMessage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
     
        Cursor cursor = db.query(TABLE_INBOX, new String[] { COLUMN_DATE,
        		COLUMN_TIME, COLUMN_CONTENT }, COLUMN_DATE + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        
        if (cursor != null)
            cursor.moveToFirst();
        String date = cursor.getString(0);
        return date;
    }
     
    // Getting all messages
    public ArrayList<String[]> getAllMessages() {
        ArrayList<String[]> messageList = new ArrayList<String[]>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_INBOX;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	String[] msg = {cursor.getString(0), cursor.getString(1), cursor.getString(2)};
            	messageList.add(msg);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return messageList;
    }
 
    // Getting messages Count
    public int getMessagesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_INBOX;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }

}
