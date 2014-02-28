package com.fei.exercicemaster.adapter;

import java.util.Date;
import java.util.List;

import com.fei.exercicemaster.entity.ExerciseDetail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MainListAdapter extends BaseAdapter {
	private List<ExerciseDetail> detailList;
	private Context context;

	static class ViewHolder{
		 int id;
		 String type;
		 String count;
		 Date createDate;
	}
	public MainListAdapter(List<ExerciseDetail> detailList, Context context) {
		this.detailList = detailList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return detailList.size();
	}

	@Override
	public Object getItem(int position) {
		return detailList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			
		} else {
			holder =  (ViewHolder) convertView.getTag();
		}
		return convertView;
	}

}
