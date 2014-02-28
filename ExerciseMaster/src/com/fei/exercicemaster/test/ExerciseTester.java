package com.fei.exercicemaster.test;

import java.text.ParseException;
import java.util.Date;

import com.fei.exercicemaster.db.ExerciseDbHelper;
import com.fei.exercicemaster.db.dao.ExerciseDetailDao;
import com.fei.exercicemaster.entity.ExerciseDetail;

import android.test.AndroidTestCase;

public class ExerciseTester extends AndroidTestCase {
	public void testCreateDb () {
		ExerciseDbHelper helper = new ExerciseDbHelper(getContext());
		helper.getReadableDatabase();
	}
	
	public void testInsert (){
		ExerciseDetailDao dao = new ExerciseDetailDao(getContext());
		dao.insert(new ExerciseDetail("test", "12|21321|323", new Date()));
	}
	
	public void testIsExist (){
		ExerciseDetailDao dao = new ExerciseDetailDao(getContext());
		assertEquals(true, dao.isExist(new Date(),"test"));
	}
	
	public void retrieveAll () throws ParseException{
		ExerciseDetailDao dao = new ExerciseDetailDao(getContext());
		dao.retrieveAll();
	}
	
	public void delete () throws ParseException{
		ExerciseDetailDao dao = new ExerciseDetailDao(getContext());
		dao.delete(new Date(),"test");
	}
}
