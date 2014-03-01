package com.fei.exercicemaster.db.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fei.exercicemaster.db.ExerciseDbHelper;
import com.fei.exercicemaster.entity.ExerciseDetail;
import com.fei.exercicemaster.util.Constant;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ExerciseDetailDao {
	private ExerciseDbHelper helper;


	public ExerciseDetailDao(Context context) {
		helper = new ExerciseDbHelper(context);
	}
	
	public boolean isExist (Date createDate , String type) {
		boolean isExist = false;
		SQLiteDatabase db = helper.getReadableDatabase();
		if (db.isOpen()) {
			StringBuilder sb = new StringBuilder();
			sb.append("select ");
			sb.append(ExerciseDbHelper._ID);
			sb.append(" from ");
			sb.append(ExerciseDbHelper.TABLE_NAME_EXERCISE_DETAIL);
			sb.append(" where ");
			sb.append(ExerciseDbHelper.CREATE_DATE);
			sb.append(" = ?");
			sb.append("  and ");
			sb.append(ExerciseDbHelper.TYPE);
			sb.append(" = ?");
			Cursor cursor = db.rawQuery(sb.toString(), new String[] {new SimpleDateFormat(Constant.DATE_FORMAT).format(createDate).toString(), type});
			if (cursor.moveToNext()) {
				isExist = true;
			}
		}
		return isExist;
	}
	
	public boolean insert (ExerciseDetail detail) {
		if (detail == null) {
			return false;
		}
		SQLiteDatabase db = helper.getWritableDatabase();
		if (db.isOpen()) {
			StringBuilder sb = new StringBuilder();
			sb.append("insert into ");
			sb.append(ExerciseDbHelper.TABLE_NAME_EXERCISE_DETAIL);
			sb.append(" ( ");
			sb.append(ExerciseDbHelper.TYPE);
			sb.append(",");
			sb.append(ExerciseDbHelper.COUNT);
			sb.append(",");
			sb.append(ExerciseDbHelper.CREATE_DATE);
			sb.append(")");
			sb.append(" values (?,?,?)");
			String type = detail.getType();
			String count = detail.getCount();
			Date createDate = detail.getCreateDate();
			db.execSQL(sb.toString(), new Object[]{type,count,new SimpleDateFormat(Constant.DATE_FORMAT).format(createDate)});
			db.close();
		}
		return true;
	}
	
	
	public List<ExerciseDetail> retrieveAll () throws ParseException {
		List<ExerciseDetail> list = new ArrayList<ExerciseDetail>();
		ExerciseDetail detail = null;
		SQLiteDatabase db = helper.getReadableDatabase();
		if (db.isOpen()) {
			String sql = "select * from " + ExerciseDbHelper.TABLE_NAME_EXERCISE_DETAIL;
			Cursor cursor = db.rawQuery(sql, null);
			while (cursor.moveToNext()) {
				detail = new ExerciseDetail(cursor.getInt(cursor.getColumnIndex(ExerciseDbHelper._ID)),
						cursor.getString(cursor.getColumnIndex(ExerciseDbHelper.TYPE)),
						cursor.getString(cursor.getColumnIndex(ExerciseDbHelper.COUNT)),
						new SimpleDateFormat(Constant.DATE_FORMAT).parse(cursor.getString(cursor.getColumnIndex(ExerciseDbHelper.CREATE_DATE))));
				list.add(detail);
				detail = null;
			}
			db.close();
		}
		return list;
	}
	
	public boolean delete(Date createDate , String type){
		int affectRows = 0;
		SQLiteDatabase db = helper.getReadableDatabase();
		if (db.isOpen()) {
			affectRows = db.delete(ExerciseDbHelper.TABLE_NAME_EXERCISE_DETAIL,
					ExerciseDbHelper.CREATE_DATE + " = ?  and " 
					+ExerciseDbHelper.TYPE + " = ? " ,  
					new String[] {new SimpleDateFormat(Constant.DATE_FORMAT).format(createDate).toString(), type});
		}
		return affectRows > 0 ? true : false;
	}
	
}
	
