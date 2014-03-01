package com.fei.exercicemaster.adapter;

import java.text.SimpleDateFormat;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fei.exercicemaster.R;
import com.fei.exercicemaster.entity.ExerciseDetail;
import com.fei.exercicemaster.util.Constant;

public class MainListAdapter extends BaseAdapter {
	private List<ExerciseDetail> detailList;
	private Context context;

	static class ViewHolder{
		 TextView type;
		 TextView count;
		 TextView createDate;
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
			holder = new ViewHolder();
			View view = View.inflate(context, R.layout.list_item, null);
			holder.type = (TextView) view.findViewById(R.id.row_type);
			holder.count = (TextView) view.findViewById(R.id.row_num);
			holder.createDate = (TextView) view.findViewById(R.id.row_date);
			convertView.setTag(holder);
		} else {
			holder =  (ViewHolder) convertView.getTag();
		}
		holder.type.setText(detailList.get(position).getType());
		holder.count.setText(detailList.get(position).getCount());
		holder.createDate.setText(new SimpleDateFormat(Constant.DATE_FORMAT).format(detailList.get(position).getCreateDate()));
		return convertView;
	}

}
