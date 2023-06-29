package com.pontic_studio.myproperty;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.pontic_studio.myproperty.Models.Client;
import com.pontic_studio.myproperty.Models.Owner;
import com.pontic_studio.myproperty.Models.User;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

	// Tabelul de utilizatori
	private static final String USER_TABLE = "USER_TABLE";
	private static final String COLUMN_USER_USERNAME = "USER_USERNAME";
	private static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
	private static final String COLUMN_USER_ISOWNER = "USER_ISOWNER";
	private static final String COLUMN_ID = "ID";

	// Tabelul de clienți
	private static final String CLIENT_TABLE = "CLIENT_TABLE";
	private static final String COLUMN_CLIENT_NAME = "CLIENT_NAME";
	private static final String COLUMN_CLIENT_SURNAME = "CLIENT_SURNAME";

	private static final String COLUMN_CLIENT_ID = "ID";
	private static final String COLUMN_USER_ID = "ID_USER";

	// Tabelul de owneri
	private static final String OWNER_TABLE = "OWNER_TABLE";
	private static final String COLUMN_OWNER_NAME = "OWNER_NAME";
	private static final String COLUMN_OWNER_SURNAME = "CLIENT_SURNAME";
	private static final String COLUMN_OWNER_ID = "ID";


	public DataBaseHelper(@Nullable Context context) {
		super(context, "MyProperty.db", null, 5);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String createTableStatement = "CREATE TABLE " + USER_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_USERNAME + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, " + COLUMN_USER_ISOWNER + " BOOL)";
		db.execSQL(createTableStatement);


	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


		if(oldVersion < 7)
		{
			String createTableStatement = "CREATE TABLE " +  OWNER_TABLE  + "(" +
				COLUMN_OWNER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				COLUMN_OWNER_NAME + " TEXT, " +
				COLUMN_OWNER_SURNAME + " TEXT, " +
				COLUMN_USER_ID + " INTEGER, " +
				"FOREIGN KEY(" + COLUMN_USER_ID + ") REFERENCES " + USER_TABLE + "(" + COLUMN_ID + "))";
			db.execSQL(createTableStatement);
		}

	}


	public boolean getStatusUser(int id) {
		SQLiteDatabase database = getWritableDatabase();

		// Construirea interogării SQL
		String sql = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_ID + " = " + id
			+ " AND " + COLUMN_USER_ISOWNER + " = 1"; // Verificați dacă isOwner este 1 (adevărat)

		Cursor cursor = database.rawQuery(sql, null);
		boolean isOwner = cursor.getCount() > 0; // Verificați dacă există cel puțin un rând rezultat

		return isOwner;
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
	public boolean addOne(Client client){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_CLIENT_NAME, client.getName());
		cv.put(COLUMN_CLIENT_SURNAME, client.getSurname());
		cv.put(COLUMN_USER_ID, client.getIdUser());
		long insert = db.insert(CLIENT_TABLE,null , cv);

		if(insert == -1)
		{
			return false;
		}
		else{
			return true;
		}
	}

	public boolean addOne(Owner owner){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_OWNER_NAME, owner.getName());
		cv.put(COLUMN_CLIENT_SURNAME, owner.getSurname());
		cv.put(COLUMN_USER_ID, owner.getIdUser());
		long insert = db.insert(OWNER_TABLE,null , cv);
		if(insert == -1)
		{
			return false;
		}
		else{
			return true;
		}
	}
	public List<User> getEveryone()
	{
		List<User> allUsers = new ArrayList<>();

		String querryString = "SELECT * FROM " + USER_TABLE;

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.rawQuery(querryString, null);

		if(cursor.moveToFirst())
		{
			do{
				int userID = cursor.getInt(0);
				String userUsername = cursor.getString(1);
				String userPassword = cursor.getString(2);
				boolean userIsOwner = cursor.getInt(3) == 1 ? true : false;

				User user = new User(userID,userUsername,userPassword,userIsOwner);
				allUsers.add(user);

			}while(cursor.moveToNext());


		}else{

		}



		return allUsers;
	}

	public int findUser(String username, String password) {
		SQLiteDatabase database = getWritableDatabase();
		String sql = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_USER_USERNAME + " = '" + username + "' AND " + COLUMN_USER_PASSWORD + " = '" + password + "'";
		Cursor cursor = database.rawQuery(sql, null);
		// cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			int idColumnIndex = cursor.getColumnIndex(COLUMN_ID);
			return cursor.getInt(idColumnIndex);
		} else {
			return -1; // Utilizatorul nu a fost găsit
		}
	}



	public int findClientByUserID(int id) {
		SQLiteDatabase database = getWritableDatabase();
		String sql = "SELECT * FROM " + CLIENT_TABLE + " WHERE " + COLUMN_USER_ID + " = " + id;
		Cursor cursor = database.rawQuery(sql, null);
		// cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			int idColumnIndex = cursor.getColumnIndex(COLUMN_ID);
			return cursor.getInt(idColumnIndex);
		} else {
			return -1; // Clientul nu a fost găsit
		}
	}

	public int findOwnerByUserId(int id) {
		SQLiteDatabase database = getWritableDatabase();
		String sql = "SELECT * FROM " + OWNER_TABLE + " WHERE " + COLUMN_USER_ID + " = " + id;
		Cursor cursor = database.rawQuery(sql, null);
		// cursor.moveToFirst();
		if (cursor.moveToFirst()) {
			int idColumnIndex = cursor.getColumnIndex(COLUMN_ID);
			return cursor.getInt(idColumnIndex);
		} else {
			return -1; // Clientul nu a fost găsit
		}
	}




	@SuppressLint("Range")
	public int getLastInsertedUserId() {
		int userId = -1;
		SQLiteDatabase db = this.getReadableDatabase();
		String query = "SELECT last_insert_rowid() AS " + COLUMN_ID;
		Cursor cursor = db.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			userId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
		}

		return userId;
	}

	public void deleteAll() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(USER_TABLE, null, null); // Șterge toate înregistrările din tabela USER_TABLE
		db.delete(CLIENT_TABLE, null, null); // Șterge toate înregistrările din tabela CLIENT_TABLE
		db.delete(OWNER_TABLE, null, null); // Șterge toate înregistrările din tabela OWNER_TABLE

	}

}
