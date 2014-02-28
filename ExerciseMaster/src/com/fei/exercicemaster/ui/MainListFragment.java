package com.fei.exercicemaster.ui;


import java.text.ParseException;
import java.util.List;

import com.fei.exercicemaster.R;
import com.fei.exercicemaster.adapter.MainListAdapter;
import com.fei.exercicemaster.db.dao.ExerciseDetailDao;
import com.fei.exercicemaster.entity.ExerciseDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *	功能描述：列表Fragment，用来显示滑动菜单打开后的内容
 */
public class MainListFragment extends ListFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		List<ExerciseDetail> detailList = null;
		try {
			detailList = new ExerciseDetailDao(getActivity()).retrieveAll();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MainListAdapter adapter = new MainListAdapter(detailList, getActivity());
		setListAdapter(adapter);
	}
	
}
