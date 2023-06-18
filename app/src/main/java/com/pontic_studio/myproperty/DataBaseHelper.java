package com.pontic_studio.myproperty;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.pontic_studio.myproperty.Models.User;

public class DataBaseHelper extends SQLiteOpenHelper {

	public static final String USER_TABLE = "USER_TABLE";
	public static final String COLUMN_USER_USERNAME = "USER_USERNAME";
	public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
	public static final String COLUMN_USER_ISOWNER = "USER_ISOWNER";
	public static final String COLUMN_ID = "ID";

	public DataBaseHelper(@Nullable Context context) {
		super(context, "MyProperty.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String createTableStatement = "CREATE TABLE " + USER_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_ISOWNER + " BOOL)";
		db.execSQL(createTableStatement);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


	}

	public boolean addOne(User user){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();

		cv.put(COLUMN_USER_USERNAME, user.getUsername());
		cv.put(COLUMN_USER_PASSWORD, user.getPassword());
		cv.put(COLUMN_USER_ISOWNER, user.isOwner());
		long insert = db.insert(USER_TABLE,null , cv);

		if(insert == -1)
		{
			return false;
		}
		else{
		return true;
		}
	}

}
