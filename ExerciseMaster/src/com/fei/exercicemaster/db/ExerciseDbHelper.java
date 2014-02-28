package com.fei.exercicemaster.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ExerciseDbHelper extends SQLiteOpenHelper {
	public static final String TABLE_NAME_EXERCISE_DETAIL = "exercise_detail";
	public static final String _ID = "_id";
	public static final String TYPE = "type";
	public static final String COUNT = "count";
	public static final String CREATE_DATE = "create_date";
	
	public ExerciseDbHelper(Context context) {
		super(context, "exercise.db", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table " + TABLE_NAME_EXERCISE_DETAIL +" ("
				+ _ID +" integer primary key autoincrement , " 
				+ TYPE +" varchar(5), "
				+ COUNT+" varchar(20) ,"
				+CREATE_DATE +" date)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
